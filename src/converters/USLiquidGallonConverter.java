package converters;

public class USLiquidGallonConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 3.785;
    }

    public double toBasicUnit(double value) {
        return value * 3.785;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString()
    {
        String textComboBox = String.format("US liquid gallon (gal) [%s]: %s", MeasureType.VOLUME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}