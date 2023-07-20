<?php
$customerId = $_GET['customers'];

$servername = 'localhost';
$username = 'root';
$password = '';
$dbname = 'customers';

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die('Connection failed: ' . $conn->connect_error);
}

$sql = "SELECT name, info FROM customers WHERE id = '$customerId'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    $customerName = $row['name'];
    $customerInfo = $row['info'];

    echo "<h3>Customer Information</h3>";
    echo "<p><strong>Name:</strong> $customerName</p>";
    echo "<p><strong>Info:</strong> $customerInfo</p>";
} else {
    echo "Customer not found.";
}

$conn->close();
