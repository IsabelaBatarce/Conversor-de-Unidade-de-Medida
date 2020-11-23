package converters;

public class NanometreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value * 1e+9;
    }

    public double toBasicUnit(double value) {
        return value / 1e+9;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("nanometre (nm) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}