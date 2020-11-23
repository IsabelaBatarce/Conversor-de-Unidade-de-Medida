package converters;

public class DecametreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 10;
    }

    public double toBasicUnit(double value) {
        return value * 10;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("decametre (dam) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}