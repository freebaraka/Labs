fun main() {
    println("Welcome to the Tenant Management System")

    // PART 1 - Variables
    val tenantId = 1001
    val tenantName = "Jane Wanjiku"
    val phoneNumber = "0712345678"
    val houseNumber = "A-204"
    val monthlyRent = 25000
    var amountPaid = 15000

    println("Tenant $tenantId, phone $phoneNumber")
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
    val amountPaidTyped: Int = 20000

    val block: Char = 'A'
    val isActive: Boolean = true

    println("Typed: $tenantIdTyped, $tenantNameTyped, $phoneNumberTyped, house $houseNumberTyped, " +
            "rent $monthlyRentTyped, paid $amountPaidTyped, block $block, active $isActive")

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
    // Calling greeting.uppercase() alone would do nothing useful here: Strings are immutable,
    // so the call returns a new String that must be captured (or printed) to be of any use.
    println(greeting)
    println("Uppercase shown correctly: ${greeting.uppercase()}")

    // PART 4 - Operators
    println("\n===== PART 4 =====")

    // Task 4.1
    val balance = monthlyRent - amountPaid
    println("Balance: KES $balance")

    // Task 4.2 - Predict first
    val percentPaidWrong = (amountPaid / monthlyRent) * 100
    println("Paid (buggy): $percentPaidWrong%")
    // What happened: amountPaid and monthlyRent are both Int, so `amountPaid / monthlyRent`
    // performs INTEGER division, truncating the true fractional result to 0 before multiplying
    // by 100 - giving "Paid (buggy): 0%" instead of the real percentage.
    //
    // Fix 1: convert one operand to Double before dividing.
    val percentPaidFix1 = (amountPaid.toDouble() / monthlyRent) * 100
    println("Paid (fix 1): ${percentPaidFix1.toInt()}%")
    // Fix 2: multiply by 100 first so the division happens on a larger Int that divides evenly.
    val percentPaidFix2 = (amountPaid * 100) / monthlyRent
    println("Paid (fix 2): $percentPaidFix2%")

    // Task 4.3
    val instalment = 6000
    val fullInstalments = monthlyRent / instalment
    val remaining = monthlyRent % instalment
    println("Full instalments: $fullInstalments")
    println("Remaining amount: KES $remaining")

    // Task 4.4 - numeric operator method syntax instead of symbols
    val totalRent = monthlyRent.times(6)   // equivalent to monthlyRent * 6
    println("Total rent (6 months): $totalRent")

    // Task 4.5 - no if statement, direct boolean expression
    val isRentPaid: Boolean = amountPaid >= monthlyRent
    println("Is rent paid: $isRentPaid")

    // Task 4.6
    val isRentOutstanding = amountPaid < monthlyRent
    var monthsInArrears = 2
    val needsReminder = isRentOutstanding && monthsInArrears > 1
    println("Needs reminder (2 months arrears): $needsReminder")

    monthsInArrears = 1
    val needsReminderAt1Month = isRentOutstanding && monthsInArrears > 1
    println("Needs reminder (1 month arrears): $needsReminderAt1Month")
    // With monthsInArrears = 1, needsReminder becomes false, because the second condition
    // (monthsInArrears > 1) is no longer true - both conditions must be true for && to be true.

    // PART 5 - Making Decisions
    println("\n===== PART 5 =====")

    // Task 5.1 - test with three different amountPaid values
    for (testAmountPaid in listOf(20000, 25000, 30000)) {
        val testBalance = monthlyRent - testAmountPaid
        if (testBalance > 0) {
            println("amountPaid=$testAmountPaid -> Rent is outstanding")
        } else {
            println("amountPaid=$testAmountPaid -> Rent is fully paid")
        }
    }

    // Task 5.2 - if / else if / else classification
    println("--- Task 5.2 ---")
    for (testAmountPaid in listOf(20000, 25000, 16000, 30000)) {
        val testBalance = monthlyRent - testAmountPaid
        if (testBalance <= 0) {
            println("balance=$testBalance -> Rent is fully paid")
        } else if (testBalance < 10000) {
            println("balance=$testBalance -> Small outstanding balance")
        } else {
            println("balance=$testBalance -> Large outstanding balance")
        }
    }

    // Task 5.3 - same logic rewritten as `when`
    println("--- Task 5.3 (when version) ---")
    for (testAmountPaid in listOf(20000, 25000, 16000, 30000)) {
        val testBalance = monthlyRent - testAmountPaid
        val message = when {
            testBalance <= 0 -> "Rent is fully paid"
            testBalance < 10000 -> "Small outstanding balance"
            else -> "Large outstanding balance"
        }
        println("balance=$testBalance -> $message")
    }
    // The `when` version reads more clearly here: each condition lines up on its own row
    // like a small table, which makes it easier to scan than a chain of if/else-if/else.

    // Task 5.4 - when with ranges
    println("--- Task 5.4 ---")
    for (testMonthsInArrears in listOf(0, 2, 4, 8, 15)) {
        val classification = when (testMonthsInArrears) {
            0 -> "Rent is up to date"
            in 1..2 -> "Early arrears"
            in 3..5 -> "Serious arrears"
            in 6..12 -> "Critical arrears"
            else -> "Review tenant account"
        }
        println("monthsInArrears=$testMonthsInArrears -> $classification")
    }

    // Task 5.5 - when on a String status
    println("--- Task 5.5 ---")
    for (status in listOf("ACTIVE", "VACATED", "PENDING", "UNKNOWN")) {
        val message = when (status) {
            "ACTIVE" -> "Tenant is currently occupying the house."
            "VACATED" -> "Tenant has moved out."
            "PENDING" -> "Tenant's move-in is still pending."
            else -> "Unrecognised tenant status."
        }
        println("$status -> $message")
    }
}