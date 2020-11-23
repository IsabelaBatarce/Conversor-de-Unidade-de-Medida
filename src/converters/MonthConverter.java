package converters;

public class MonthConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 2.628e+6;
    }

    public double toBasicUnit(double value) {
        return value * 2.628e+6;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("month (m) [%s]: %s", MeasureType.TIME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}