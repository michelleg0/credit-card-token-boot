document.getElementById("exportBtn").addEventListener("click", () => {
    fetch("http://localhost:8080/customers/export")
        .then(response => {
            if (!response.ok) {
                throw new Error("Export failed");
            }
            return response.json();
        })
        .then(data => console.log("Exported Data:", data))
        .catch(error => {
            console.error("Error:", error);
            alert("Export failed");
        });
});

//make a get request - fetch to get csv file and download
