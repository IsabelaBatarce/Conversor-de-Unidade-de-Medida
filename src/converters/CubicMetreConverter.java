package converters;

public class CubicMetreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 1000;
    }

    public double toBasicUnit(double value) {
        return value * 1000;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("cubic metre (m³) [%s]: %s", MeasureType.VOLUME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}