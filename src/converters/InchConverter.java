package converters;

public class InchConverter implements IConverterMaster {

    /**
     * @param value
     * @return double
     * 
     *         responsavel por tranformar a variavel do padrao internacional para um
     *         especifico
     */
    public double fromBasicUnit(double value) {
        return value * 39.37;
    }

    /**
     * @param value
     * @return double
     * 
     *         responsavel por tranformar a variavel do padrao especifico para um
     *         Internacional
     */
    public double toBasicUnit(double value) {
        return value / 39.37;
    }

    /**
     * @param sourceMeasurement
     * @param value
     * @return Double
     * 
     *         Responsavel por pegar a unidade origem e mandar para a unidade
     *         destino
     */
    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    /**
     * @return String
     * 
     *         texto exibido no combo box
     */
    public String toString() {
        String textComboBox = String.format("inch (in) [%s]: %s", MeasureType.DISTANCE.getTypeString(),
                getClass().getCanonicalName());

        return textComboBox;
    }
}