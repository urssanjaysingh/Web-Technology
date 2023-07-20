<!DOCTYPE html>
<html>

    <head>
        <title>Process Details</title>
    </head>

    <body>
        <center>
            <?php

            $conn = mysqli_connect("localhost", "root", "", "student");

            if ($conn === false) {
                die("ERROR: Could not connect. "
                    . mysqli_connect_error());
            }

            $name = $_REQUEST['name'];
            $roll_no = $_REQUEST['roll_no'];
            $email = $_REQUEST['email'];
            $phone = $_REQUEST['phone'];
            $dob = $_REQUEST['dob'];
            $gender = $_REQUEST['gender'];
            $address = $_REQUEST['address'];

            $sql = "INSERT INTO studentdetails VALUES ('$name',
            '$roll_no','$email','$phone','$dob', '$gender', '$address')";

            if (mysqli_query($conn, $sql)) {
                echo "<h3>data stored in a database successfully."
                    . " Please browse your localhost php my admin"
                    . " to view the updated data</h3>";

                echo nl2br("\n$name\n $roll_no\n "
                    . "$email\n $phone\n $dob\n $gender\n $address");
            } else {
                echo "ERROR: Hush! Sorry $sql. "
                    . mysqli_error($conn);
            }

            // Close connection
            mysqli_close($conn);
            ?>
        </center>
    </body>

</html>