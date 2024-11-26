package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int STEP = 1;
    private static final String POSITION_SIGNATURE = "-";
    private static final String FORMAT = "%s : %s";

    private final Name name;
    private int position;

    public Car(final Name name) {
        this(name, 0);
    }

    Car(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int condition) {
        if (condition >= MOVE_THRESHOLD) {
            this.position += STEP;
        }
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isEqualPosition(int target) {
        return position == target;
    }

    @Override
    public boolean equals(final Object o) {
        return name.equals(((Car) o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return String.format(FORMAT, name,
                POSITION_SIGNATURE.repeat(position));
    }
}
