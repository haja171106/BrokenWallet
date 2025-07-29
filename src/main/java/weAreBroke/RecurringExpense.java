package weAreBroke;

import java.time.LocalDate;

public class RecurringExpense {
        private String recurrence;

        public RecurringExpense(String label, double amount, LocalDate date, String recurrence) {
            super();
            if (!recurrence.equals("monthly") && !recurrence.equals("yearly")) {
                throw new IllegalArgumentException("Recurrence must be 'monthly' or 'yearly'");
            }
            this.recurrence = recurrence;
        }

        public String getRecurrence() {
            return recurrence;
        }

        @Override
        public String toString() {
            return super.toString() + " (récurrence: " + recurrence + ")";
        }

}
