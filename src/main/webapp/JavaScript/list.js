function viewPlayer(playerId) {
    window.location.href = "profile?id=" + playerId;
}

function confirmDelete(playerId) {
    var confirmAction = confirm("Are you sure you want to delete this player?");
    if (confirmAction) {
        // Perform the delete action via a request (e.g., using AJAX or redirecting to a delete servlet)
        alert("Player " + playerId + " has been deleted.");
    }
}