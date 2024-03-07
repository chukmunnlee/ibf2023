package ibf2023.ssf.day13.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Todo {

   @NotEmpty(message = "Please say what you will be doing")
   private String task;

   @Min(value=1, message = "Minimum value is 1")
   @Max(value=5, message = "Maximum value is 1")
   private int priority;

   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @NotNull(message = "Must set a due date")
   @FutureOrPresent(message = "Due date must be in the future")
   private LocalDate dueDate;

   public String getTask() { return task; }
   public void setTask(String task) { this.task = task; }

   public int getPriority() { return priority; }
   public void setPriority(int priority) { this.priority = priority; }

   public LocalDate getDueDate() { return dueDate; }
   public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

   @Override
   public String toString() {
      return "Todo [task=" + task + ", priority=" + priority + ", dueDate=" + dueDate + "]";
   }

}
