import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentaPasajes {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(()-> {

            JFrame ventana = new JFrame("Sistema de venta de Pasajes");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(600,400);
            ventana.setLocationRelativeTo(null);

            ventana.setLayout(new BorderLayout());

            JLabel titulo = new JLabel("Búsqueda de Pasajes", SwingConstants.CENTER);

            JPanel panelFormulario = new JPanel(new GridLayout(5,2,10,10));

            panelFormulario.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

            JLabel lblOrigen = new JLabel("Origen:");
            JComboBox<String> cbSalida =
                    new JComboBox<>(new String[]{
                            "Buenos Aires",
                            "Mendoza",
                            "Cordoba",
                            "Santa Fe"
                    });
            JLabel lblDestino = new JLabel("Destino:");
            JComboBox<String> cbDestino =
                    new JComboBox<>(new String[]{
                       "Buenos Aires",
                       "Mendoza",
                       "Cordoba",
                       "Santa Fe"
                    });

            JLabel lblFecha = new JLabel("Fecha:");
            JTextField txtFecha =
                    new JTextField();

            JCheckBox checkDirecto =
                    new JCheckBox("Solo vuelos directos");

            JButton btnBuscar = new JButton("Buscar vuelos");
            btnBuscar.setEnabled(false);

            JLabel lblResultado = new JLabel("Complete la fecha para comenzar");

            panelFormulario.add(lblOrigen);
            panelFormulario.add(cbSalida);

            panelFormulario.add(lblDestino);
            panelFormulario.add(cbDestino);

            panelFormulario.add(lblFecha);
            panelFormulario.add(txtFecha);

            panelFormulario.add(new JLabel(""));
            panelFormulario.add(checkDirecto);

            txtFecha.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    btnBuscar.setEnabled(
                            !txtFecha.getText()
                                    .trim()
                                    .isEmpty());
                }
            });

            btnBuscar.addActionListener(e -> {

                String origen = cbSalida.getSelectedItem().toString();

                String destino = cbDestino.getSelectedItem().toString();

                String fecha = txtFecha.getText();

                String directo = checkDirecto.isSelected() ?
                        "Directo" : "Con escalas";

                lblResultado.setText(
                        "Vuelo: " + origen + " - " + destino + " - " + fecha + " - " + directo
                );
            });

            lblResultado.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    lblResultado.setForeground(Color.BLUE);
                }
               @Override
                public void mouseExited(MouseEvent e) {
                    lblResultado.setForeground(Color.BLACK);
               }
            });

            JPanel panelInferior = new JPanel();
            panelInferior.add(btnBuscar);

            panelFormulario.add(lblResultado);
            ventana.add(titulo, BorderLayout.PAGE_START);
            ventana.add(panelFormulario, BorderLayout.CENTER);
            ventana.add(panelInferior, BorderLayout.PAGE_END);

            ventana.setVisible(true);

        });

    }
}

/*
La aplicación simula una búsqueda de boletos de avión, ya que el final trata de este tema,
decidí hacerla para ir teniendo una idea de como será, el usuario debe seleccionar lugar de salida y destino,
indicar la fecha y si quiere solo vuelos directos, se utilizó borderLayout para estructura principal
de las ventanas, y gridLayout para la distribucion de componentes de la ventana, tiene 3 eventos,
ActionListener para la busqueda cuando se presiona el boton, KeyListener para habilitar el boton una vez se ingresa la fecha,
y mouseListener para la etiqueta de resultado, el boton de busqueda inicia deshabilitado y cambia al poner la fecha
 */
