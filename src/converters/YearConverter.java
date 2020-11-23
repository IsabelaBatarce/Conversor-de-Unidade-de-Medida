package converters;

public class YearConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 3.154e+7;
    }

    public double toBasicUnit(double value) {
        return value * 3.154e+7;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("year (y) [%s]: %s", MeasureType.TIME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}