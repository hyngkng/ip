public class TimedTask extends Task {
    protected String time;

    public TimedTask(String description, String when) {
        super(description);
        this.time = when;
    }

    @Override
    public String toString() {
        return this.getTypeIcon() + this.getStatusIcon() + " " + description + " - " + time;
    }
}