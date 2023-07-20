console.clear();

function validateEmail(email) {
    // Regular expression pattern for validating email addresses
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // Check if the email matches the pattern
    if (emailPattern.test(email)) {
        return true; // Valid email address
    }

    return false; // Invalid email address
}

const email = "example@example.com";
const isValid = validateEmail(email);

if (isValid) {
    console.log("Valid email address");
} else {
    console.log("Invalid email address");
}
