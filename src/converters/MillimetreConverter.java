package converters;

public class MillimetreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value * 1000;
    }

    public double toBasicUnit(double value) {
        return value / 1000;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("millimetre (mm) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}