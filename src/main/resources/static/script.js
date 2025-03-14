document.getElementById("exportBtn").addEventListener("click", function() {
    fetch("/export/customers")
        .then(response => response.json())
        .then(data => {
            console.log("Exported Data:", data);
            alert("Export successful!");
        })
        .catch(error => {
            console.error("Export failed:", error);
            alert("Export failed");
        });
});
