package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Responsavel pela janela inicial aberta assim que o código e executado
 */
class MainWindow extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel statusPanel;
    private JLabel statusLabel;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuItem menuUnitConverter;
    private JMenuItem menuItemExit;
    private JMenuItem menuItemHelp;
    private JMenuItem menuItemDisclaimer;
    private JMenuItem menuItemAbout;

    MainWindow(String title) throws HeadlessException {
        super(title);
        setupWindow();
        setupMenus();
        bindMenus();
        setupExtraComponents();
        setupWindowsListener();
        this.setStatus(Info.getLongVersion());
    }

    /**
     * @param actionEvent Responsavel por definir as ações tomadas ao clicar os
     *                    botoes do menu
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.menuItemExit) {
            exitSystem();
        }

        if (actionEvent.getSource() == this.menuUnitConverter) {
            Interface frmUnitConverter = new Interface("Interface");

            frmUnitConverter.setLocationRelativeTo(null);
            frmUnitConverter.setVisible(true);
        }

        if (actionEvent.getSource() == this.menuItemHelp) {
            new MsgScreen(this, "Help for " + Info.getLongVersion(), Info.getHelpText());
        }

        if (actionEvent.getSource() == this.menuItemDisclaimer) {
            new MsgScreen(this, "Disclaimer " + Info.getLongVersion(), Info.getDisclaimerText());
        }

        if (actionEvent.getSource() == this.menuItemAbout) {
            new MsgScreen(this, "About " + Info.getLongVersion(), Info.getAboutText());
        }
    }

    /**
     * @param listener
     * @param menu
     * 
     */
    private void bindItems(ActionListener listener, JMenu menu) {
        for (Component target : menu.getMenuComponents()) {
            if (target instanceof JMenuItem) {
                ((JMenuItem) target).addActionListener(this);
            }
        }
    }

    private void bindMenus() {
        for (Component target : this.getJMenuBar().getComponents()) {
            if (target instanceof JMenu) {
                bindItems(this, (JMenu) target);
            }
        }
    }

    /**
     * @param label
     * @param shortcut
     * @return JMenu Responsavel por criar um menu customizado
     */
    private JMenu createCustomizedMenu(String label, char shortcut) {
        JMenu temp = new JMenu(label);
        temp.setMnemonic(shortcut);
        return (temp);
    }

    /**
     * @param label
     * @param shortcut
     * @return JMenuItem
     * 
     */
    private JMenuItem createCustomizedMenuItem(String label, char shortcut) {
        JMenuItem temp = new JMenuItem(label);
        temp.setMnemonic(shortcut);
        return (temp);
    }

    void exitSystem() {
        System.exit(0);
    }

    /**
     * Responsavel por tornar a interface visivel
     */
    void go() {
        this.setVisible(true);
    }

    /**
     * @param message
     */
    void setStatus(String message) {
        statusLabel.setText(message);
    }

    private void setupExtraComponents() {
        setupStatusPanel();
    }

    /**
     * Responsavel por setar os dados dos menus
     */
    private void setupMenus() {
        menuFile = createCustomizedMenu("File", 'F');
        menuHelp = createCustomizedMenu("Help", 'H');

        menuUnitConverter = createCustomizedMenuItem("Unit of Measure Converter", 'U');
        menuItemExit = createCustomizedMenuItem("Exit", 'X');

        menuItemHelp = createCustomizedMenuItem("Help", 'L');
        menuItemDisclaimer = createCustomizedMenuItem("Disclaimer", 'D');
        menuItemAbout = createCustomizedMenuItem("About", 'A');

        // First menu
        menuFile.add(menuUnitConverter);
        menuFile.addSeparator();
        menuFile.add(menuItemExit);

        // Last menu
        menuHelp.add(menuItemHelp);
        menuHelp.add(menuItemDisclaimer);
        menuHelp.addSeparator();
        menuHelp.add(menuItemAbout);

        // JMenuBar
        menuBar = new JMenuBar();
        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        this.setJMenuBar(menuBar);
    }

    private void setupStatusPanel() {
        this.statusPanel = new JPanel();
        this.statusLabel = new JLabel();
        this.statusPanel.add(statusLabel);
        this.statusPanel.setBackground(Color.gray);
        this.statusPanel.setBorder(BorderFactory.createEtchedBorder());
        getContentPane().add(statusPanel, BorderLayout.SOUTH);
    }

    private void setupWindow() {
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.3),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.3));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(2, 2));
    }

    private void setupWindowsListener() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                exitSystem();
            }
        });
    }

}
