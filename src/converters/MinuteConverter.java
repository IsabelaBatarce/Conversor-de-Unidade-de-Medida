package converters;

public class MinuteConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 60;
    }

    public double toBasicUnit(double value) {
        return value * 60;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("minute (n) [%s]: %s", MeasureType.TIME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}