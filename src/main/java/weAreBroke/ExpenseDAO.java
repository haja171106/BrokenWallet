package weAreBroke;

import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;
 public class ExpenseDAO {
        private List<Expense> expenses;

        public ExpenseDAO() {
            this.expenses = new ArrayList<>();
        }

        public void addExpense(Expense e) {
            expenses.add(e);
        }
        public List<RefundableExpense> getUnrefundedExpenses() {
            return expenses.stream()
                    .filter(e -> e instanceof RefundableExpense)
                    .map(e -> (RefundableExpense) e)
                    .filter(e -> !e.isRefunded())
                    .collect(Collectors.toList());
        }

        public double  getTotalRecurringExpenses() {
            return expenses.stream()
                 .filter(RecurringExpense.class::isInstance)
                 .mapToDouble(Expense::getAmount)
                 .sum();
        }

        public List<String> getLargeExpenseLabels() {
            return expenses.stream()
                    .filter(Expense::isLargeExpense)
                    .map(Expense::getLabel)
                    .collect(Collectors.toList());
        }


        public double getTotalExpenses() {
            return expenses.stream()
                    .mapToDouble(Expense::getAmount)
                    .sum();
        }
    }

