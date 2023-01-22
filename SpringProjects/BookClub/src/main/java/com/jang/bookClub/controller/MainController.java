package com.jang.bookClub.controller;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jang.bookClub.models.Books;
import com.jang.bookClub.models.LoginUser;
import com.jang.bookClub.models.User;
import com.jang.bookClub.service.BookService;
import com.jang.bookClub.service.UserService;


@Controller
public class MainController {
	    // Add once service is implemented:
 @Autowired
 private UserService userServ;
 
 @Autowired
 private BookService bookService;

@GetMapping("/")
public String index(Model model) {
    model.addAttribute("newUser", new User());
    model.addAttribute("newLogin", new LoginUser());
    return "login.jsp";
}

@PostMapping("/createBook/post")
public String createBookPost(@Valid @ModelAttribute("newBook") Books newBook, BindingResult result, Model model) {
	if (result.hasErrors()) {
		model.addAttribute("newBook", newBook);
		return "createBook.jsp";
	}
	bookService.createBook(newBook);
	return "redirect:/home";
}


@GetMapping("/create/book")

public String createBook(@ModelAttribute("newBook") Books newBook, HttpSession session, Model model) {
	Long userId = (Long) session.getAttribute("userId");
	if (userId == null) {
		return "redirect:/";
	}
	User user = userServ.findUser((Long)session.getAttribute("userId"));
	model.addAttribute("user", user);
	return "createBook.jsp";
}


@PostMapping("/register")
public String register(@Valid @ModelAttribute("newUser") User newUser, 
        BindingResult result, Model model, HttpSession session) {
    
	userServ.register(newUser, result);
    if(result.hasErrors()) {
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    User createdUser = userServ.createUser(newUser);
    session.setAttribute("userId", createdUser.getId());
    return "redirect:/home";
}


@PostMapping("/login")
public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
        BindingResult result, Model model, HttpSession session) {
	User loggedUser = userServ.login(newLogin, result);
	
    if(loggedUser == null) {
        model.addAttribute("newUser", new User());
        return "login.jsp";
    }

    session.setAttribute("userId", loggedUser.getId());
    return "redirect:/home";
}


@GetMapping("/logout")
public String logout(HttpSession session) {
	session.removeAttribute("userId");
	return "redirect:/";
}


@RequestMapping("/home")
public String homePage(Model model, HttpSession session) {
	Long userId = (Long) session.getAttribute("userId");
	if (userId == null) {
		return "redirect:/";
	}
	List<Books> books = bookService.allBooks();
	model.addAttribute("books", books);
	model.addAttribute("user", userServ.findUser(userId));
        return "new.jsp";
    }

@GetMapping("books/{id}")

public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
	Long userId = (Long) session.getAttribute("userId");
	if (userId == null) {
		return "redirect:/";
	}
	model.addAttribute("book", bookService.findBook(id));
	model.addAttribute("userId", userId);
	
	return "oneBook.jsp";
}

@GetMapping("/edit/{id}")
public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    Long userId = (Long) session.getAttribute("userId");
    if (userId == null) {
        return "redirect:/";
    }
    Books book = bookService.findBook(id);
    User bookUser = book.getUser();

    if (userId.equals(bookUser.getId())) {
        model.addAttribute("book", book);
        return "editBook.jsp";
    } else {
        return "redirect:/home";
    }
}

@GetMapping("/add/borrower/{id}")
public String updateBookStatus(@PathVariable("id") Long id, Model model, HttpSession session) {
	 Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/";
	    }
	Books oneBook = bookService.findBook(id);
	oneBook.setBorrower(userServ.findUser((userId)));
	bookService.updateBook(oneBook);
	return "redirect:/home";
	
}
@GetMapping("/return/borrower/{id}")
public String updateBookStatusreturn(@PathVariable("id") Long id, Model model, HttpSession session) {
	 Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/";
	    }
	Books oneBook = bookService.findBook(id);
	oneBook.setBorrower(null);
	bookService.updateBook(oneBook);
	return "redirect:/home";
	
}


@PutMapping("/edit/{id}")
public String editRoute(@Valid @ModelAttribute("book") Books book, BindingResult result, @PathVariable("id") Long id, Model model) {
	if(result.hasErrors()) {
		model.addAttribute("book", book);
		return "editBook.jsp";
	}
	bookService.updateBook(book);
	return "redirect:/home";
}

@DeleteMapping("/books/{id}")
public String delete(@PathVariable("id") Long id, Model model, HttpSession session) {
	Long userId = (Long) session.getAttribute("userId");
    if (userId == null) {
        return "redirect:/";
    }
    Books book = bookService.findBook(id);
    User bookUser = book.getUser();

    if (userId.equals(bookUser.getId())) {
        model.addAttribute("book", book);
        bookService.deleteBook(id);
        return "redirect:/home";
    } 
    
    return "redirect:/home";

	}
}
	    
	    
	    
	    
	


