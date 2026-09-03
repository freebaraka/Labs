fun main() {
    // PART 0 - Setup
    println("Welcome to the Tenant Management System")

    // PART 1 - Variables
    val tenantId = 1001
    val tenantName = "Jane Wanjiku"
    val phoneNumber = "0712345678"
    val houseNumber = "A-204"
    val monthlyRent = 25000
    var amountPaid = 15000

    println("Amount paid before: $amountPaid")
    amountPaid += 5000
    println("Amount paid after: $amountPaid")
    // task1.3:uncomment to run it
    // tenantId = 1002
    // IntelliJ/Kotlin error: "Val cannot be reassigned"

    // PART 2 - Data Types and Casting
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
    println(rentAsDouble)

    val registrationNumber: Long = 999_999_999L
    println(registrationNumber)

    // PART 3 - Strings
    println(tenantName + " lives in house " + houseNumber)
    println("$tenantName lives in house $houseNumber")
    println("Total rent for 6 months: KES ${monthlyRent * 6}")

    val receipt = """
         RENT RECEIPT 
        Tenant: $tenantName
        House: $houseNumber
        Paid: KES $amountPaid
    """.trimIndent()
    println(receipt)

    val greeting = "Dear Tenant"
    greeting.uppercase()
    println(greeting)
    println("Uppercase shown correctly: ${greeting.uppercase()}")
}