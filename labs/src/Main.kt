fun main() {
    println("Welcome to the Tenant Management System")

    println("\n--- PART 1: Variables ---")
    val tenantId = 1001
    val tenantName = "Jane Wanjiku"
    val phoneNumber = "0712345678"
    val houseNumber = "A-204"
    val monthlyRent = 25000
    var amountPaid = 15000

    println("Amount paid before: $amountPaid")
    amountPaid += 5000
    println("Amount paid after: $amountPaid")

    // Task 1.3 (do not run as-is): val cannot be reassigned.
    // tenantId = 1002
    // IntelliJ/Kotlin error: "Val cannot be reassigned"

    println("\n--- PART 2: Data Types and Casting ---")
    val tenantIdTyped: Int = 1001
    val tenantNameTyped: String = "Jane Wanjiku"
    val phoneNumberTyped: String = "0712345678"
    val houseNumberTyped: String = "A-204"
    val monthlyRentTyped: Int = 25000
    var amountPaidTyped: Int = 20000

    val block: Char = 'A'
    var isActive: Boolean = true

    val monthlyRentInt: Int = 25000
    val rentAsDouble: Double = monthlyRentInt.toDouble()
    println("Rent as Double: $rentAsDouble")

    val registrationNumber: Long = 999_999_999L
    println("Registration number: $registrationNumber")

    println("\n--- PART 3: Strings ---")
    println(tenantName + " lives in house " + houseNumber)
    println("$tenantName lives in house $houseNumber")
    println("Total rent for 6 months: KES ${monthlyRent * 6}")
}