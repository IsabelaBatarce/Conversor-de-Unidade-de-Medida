package converters;

public class MicrometreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value * 1e+6;
    }

    public double toBasicUnit(double value) {
        return value / 1e+6;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("micrometre (µm) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}