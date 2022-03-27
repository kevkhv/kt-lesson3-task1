import kotlin.math.roundToInt

const val type0 = "Vk Pay"
const val type1 = "Mastercard/Maestro"
const val type2 = "Visa/Мир"

fun main() {
    val transfer = 15100000
    val currentCard = type2
    var lastTransfersMonth = 59000000
    val commission = calculateCommission(lastTransfersMonth, transfer, currentCard)
    val totalSum = transfer + commission
    println("Сумма перевода ${getStringRubles(transfer)}")
    println("Коммисия за перевод составляет ${getStringRubles(commission)}")
    println("Итого с учетом комиссии ${getStringRubles(totalSum)}")
}

fun calculateCommission(lastTransfersMonth: Int, transfer: Int, type: String = "Vk Pay"): Int {
    val maxLimitMaestro = 7500000
    return when (type) {
        type0 -> 0
        type1 -> if ((transfer + lastTransfersMonth) < maxLimitMaestro) 0 else (transfer * 0.0060 + 2000).roundToInt()
        type2 -> if ((transfer * 0.0075) <= 3500) 3500 else (transfer * 0.0075).roundToInt()
        else -> error("Карта не поддерживается")
    }
}

fun getStringRubles(money: Int): String {
    return "${money / 100} рублей ${money % 100} копеек"
}