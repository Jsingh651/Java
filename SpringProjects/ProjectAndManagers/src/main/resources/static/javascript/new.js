let toggleButton = document.getElementById("toggle-button");
let content = document.querySelector(".content");

toggleButton.addEventListener("click", function() {
  content.classList.toggle("flipped");
  toggleButton.classList.toggle("open");
});



