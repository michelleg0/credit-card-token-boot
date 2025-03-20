// Form submission - will need to connect to an endpoint
document.getElementById("customerForm").addEventListener("submit", function(event) {
    event.preventDefault();
    document.getElementById("result").innerText = "Form submitted!";
});

// Export data - will need to connect to an endpoint
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("exportBtn").addEventListener("click", function () {
        window.location.href = "http://localhost:8080/customers/export"; // Correct Spring Boot URL
    });
});



// Import CSV - will need to connect to an endpoint
document.getElementById("importBtn").addEventListener("click", function() {
    let fileInput = document.getElementById("csvFileInput");
    let file = fileInput.files[0];

    if (!file) {
        alert("Please select a CSV file.");
        return;
    }

    let formData = new FormData();
    formData.append("file", file);

    fetch("http://localhost:8080/api/customers/import", {
        method: "POST",
        body: formData
    })
    .then(response => response.text())
    .then(message => {
        document.getElementById("result").innerText = message;
    })
    .catch(error => {
        document.getElementById("result").innerText = "Error importing CSV.";
    });
});
