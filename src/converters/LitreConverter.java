package converters;

public class LitreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value;
    }

    public double toBasicUnit(double value) {
        return value;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("litre (l) [%s]: %s", MeasureType.VOLUME.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}