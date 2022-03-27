package ru.netology


import calculateCommission
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.IllegalStateException


class MainKtTest {

    @Test
    fun calculateCommission_shouldReturnCommissionVK0() {
        //arrange
        val lastTransfers = 200000
        val transfer = 500000
        val type = "Vk Pay"
        val expectedCommission = 0
        //act
        val actualCommission = calculateCommission(lastTransfersMonth = lastTransfers, transfer = transfer, type = type)
        //assert
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun calculateCommission_shouldAddCommissionMastercardMaestro() {
        //arrange
        val lastTransfers = 7300000
        val transfer = 200000
        val type = "Mastercard/Maestro"
        val expectedCommission = 3200
        //act
        val actualCommission = calculateCommission(lastTransfersMonth = lastTransfers, transfer = transfer, type = type)
        //assert
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun calculateCommission_shouldNotAddCommissionMastercardMaestro() {
        //arrange
        val lastTransfers = 7300000
        val transfer = 190000
        val type = "Break commit"
        val expectedCommission = 0
        //act
        val actualCommission = calculateCommission(lastTransfersMonth = lastTransfers, transfer = transfer, type = type)
        //assert
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun calculateCommission_shouldAddCommission075VisaMir() {
        //arrange
        val lastTransfers = 8000000
        val transfer = 3000000
        val type = "Visa/Мир"
        val expectedCommission = 22500
        //act
        val actualCommission = calculateCommission(lastTransfersMonth = lastTransfers, transfer = transfer, type = type)
        //assert
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun calculateCommission_shouldAddCommission35rublesVisaMir() {
        //arrange
        val lastTransfers = 8200000
        val transfer = 190000
        val type = "Visa/Мир"
        val expectedCommission = 3500
        //act
        val actualCommission = calculateCommission(lastTransfersMonth = lastTransfers, transfer = transfer, type = type)
        //assert
        assertEquals(expectedCommission, actualCommission)
    }

    @Test(expected = IllegalStateException::class)
    fun calculateCommission_Exception() {
        val lastTransfers = 8200000
        val transfer = 190000
        val type = "Union Pay"
        val actualException =
            calculateCommission(lastTransfersMonth = lastTransfers, transfer = transfer, type = type)
    }

    @Test
    fun getStringRubles() {
    }
}