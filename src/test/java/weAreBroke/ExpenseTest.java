package weAreBroke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ExpenseDAOTest {

    private ExpenseDAO expenseDAO;
    private RefundableExpense refundableExpense;
    private RecurringExpense recurringExpense;
    private Expense largeExpense;

    @BeforeEach
    void setUp() {
        refundableExpense = new RefundableExpense("Taxi", 80.0, LocalDate.now());
        recurringExpense = new RecurringExpense("Netflix", 15.0, LocalDate.now(), "monthly");
        largeExpense = new Expense("Laptop", 1200.0, LocalDate.now());

        List<Expense> expenses = Arrays.asList(refundableExpense, recurringExpense, largeExpense);
        expenseDAO = new ExpenseDAO(expenses);
    }

    @Test
    void testGetUnrefundedExpenses() {
        List<RefundableExpense> result = expenseDAO.getUnrefundedExpenses();
        assertEquals(1, result.size());
        assertFalse(result.get(0).isRefunded());
    }

    @Test
    void testGetTotalRecurringExpenses() {
        assertEquals(15.0, expenseDAO.getTotalRecurringExpenses());
    }

    @Test
    void testGetLabelsOfLargeExpenses() {
        List<String> labels = expenseDAO.getLabelsOfLargeExpenses();
        assertTrue(labels.contains("Laptop"));
    }

    @Test
    void testGetTotalExpenses() {
        assertEquals(80.0 + 15.0 + 1200.0, expenseDAO.getTotalExpenses());
    }
}
