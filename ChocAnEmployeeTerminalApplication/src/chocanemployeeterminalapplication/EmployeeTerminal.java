/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chocanemployeeterminalapplication;
import java.util.ArrayList;
import chocanstructs.Employee;
import chocanstructs.Provider;
import chocanstructs.Member;
import chocanstructs.Service;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Afeefeh
 */
public class EmployeeTerminal extends javax.swing.JFrame {

    private int clientPrivileges;
    private ChocAnEmployeeTerminal employeeTerminal;
    private int currentSDCommand;
    private int currentPCommand;
    private int currentMCommand;
    private int currentECommand;
    
    /**
     * Creates new form EmployeeTerminal
     */
    private EmployeeTerminal() {
        clientPrivileges = -1;
        employeeTerminal = new ChocAnEmployeeTerminal();
        initComponents();
        updateTabs();
        currentSDCommand = -1;
        currentPCommand = -1;
        currentMCommand = -1;
        currentECommand = -1;
    }
    
    private void updateServiceDirectoryTable()
    {
        try
        {
            ArrayList<Service> allServices = employeeTerminal.getAllServices();
            
            ServiceTable newTable = new ServiceTable(allServices);
            
            tableSD.setModel(newTable.getModel());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            employeeTerminal.disconnect();
            clientPrivileges = -1;
            updateTabs();
        }
    }
    
    private void setServiceFieldsEditable(Boolean editable)
    {
        serviceCodeInputSD.setEditable(editable);
        nameInputSD.setEditable(editable);
        feeInputSD.setEditable(editable);
        isActiveCheckboxSD.setEnabled(editable);
        submitButtonSD.setEnabled(editable);
    }
    
    private void clearDataSD()
    {
        serviceCodeInputSD.setText("");
        nameInputSD.setText("");
        feeInputSD.setText("");
        isActiveCheckboxSD.setSelected(false);
    }
    
    private void updateProviderTable()
    {
        try
        {
            ArrayList<Provider> allProviders = employeeTerminal.getAllProviders();
            
            ProviderTable newTable = new ProviderTable(allProviders);
            
            tableP.setModel(newTable.getModel());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            employeeTerminal.disconnect();
            clientPrivileges = -1;
            updateTabs();
        }
    }
    
    private void setProviderFieldsEditable(Boolean editable)
    {
        providerNumberInputP.setEditable(editable);
        passwordInputP.setEditable(editable);
        nameInputP.setEditable(editable);
        emailAddressInputP.setEditable(editable);
        addressInputP.setEditable(editable);
        cityInputP.setEditable(editable);
        stateInputP.setEditable(editable);
        zipInputP.setEditable(editable);
        isActiveCheckBoxP.setEnabled(editable);
        submitInfoP.setEnabled(editable);
    }
    
    private void clearDataP()
    {
        providerNumberInputP.setText("");
        passwordInputP.setText("");
        nameInputP.setText("");
        emailAddressInputP.setText("");
        addressInputP.setText("");
        cityInputP.setText("");
        stateInputP.setText("");
        zipInputP.setText("");
        isActiveCheckBoxP.setSelected(false);
    }
    
    private void updateMemberTable()
    {
        try
        {
            ArrayList<Member> allMembers = employeeTerminal.getAllMembers();
            
            MemberTable newTable = new MemberTable(allMembers);
            
            tableM.setModel(newTable.getModel());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            employeeTerminal.disconnect();
            clientPrivileges = -1;
            updateTabs();
        }
    }
    
    private void setMemberFieldsEditable(Boolean editable)
    {
        memberNumberInputM.setEditable(editable);
        nameInputM.setEditable(editable);
        emailAddressInputM.setEditable(editable);
        addressInputM.setEditable(editable);
        cityInputM.setEditable(editable);
        stateInputM.setEditable(editable);
        zipInputM.setEditable(editable);
        isValidCheckBoxM.setEnabled(editable);
        validityReasonInputM.setEditable(editable);
        isActiveCheckBoxM.setEnabled(editable);
        submitInfoM.setEnabled(editable);
    }
    
    private void clearDataM()
    {
        memberNumberInputM.setText("");
        nameInputM.setText("");
        emailAddressInputM.setText("");
        addressInputM.setText("");
        cityInputM.setText("");
        stateInputM.setText("");
        zipInputM.setText("");
        isValidCheckBoxM.setSelected(false);
        validityReasonInputM.setText("");
        isActiveCheckBoxM.setSelected(false);
    }
    
    private void updateEmployeeTable()
    {
        try
        {
            ArrayList<Employee> allEmployees = employeeTerminal.getAllEmployees();
            
            EmployeeTable newTable = new EmployeeTable(allEmployees);
            
            tableE.setModel(newTable.getModel());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            employeeTerminal.disconnect();
            clientPrivileges = -1;
            updateTabs();
        }
    }
    
    private void setEmployeeFieldsEditable(Boolean editable)
    {
        employeeNumberInputE.setEditable(editable);
        passwordInputE.setEditable(editable);
        nameInputE.setEditable(editable);
        emailAddressInputE.setEditable(editable);
        addressInputE.setEditable(editable);
        cityInputE.setEditable(editable);
        stateInputE.setEditable(editable);
        zipInputE.setEditable(editable);
        isActiveCheckBoxE.setEnabled(editable);
        isManagerCheckBoxE.setEnabled(editable);
        submitInfoE.setEnabled(editable);
    }
    
    private void clearDataE()
    {
        employeeNumberInputE.setText("");
        passwordInputE.setText("");
        nameInputE.setText("");
        emailAddressInputE.setText("");
        addressInputE.setText("");
        cityInputE.setText("");
        stateInputE.setText("");
        zipInputE.setText("");
        isActiveCheckBoxE.setSelected(false);
        isManagerCheckBoxE.setSelected(false);
    }
    
    private void updateTabs(){ 
         if(clientPrivileges == 0){
            mainPanel.add(serviceDirectoryPanel);
            mainPanel.setTitleAt(1, "Service Directory");
            mainPanel.add(providersPanel);
            mainPanel.setTitleAt(2, "Providers");
            mainPanel.add(membersPanel);
            mainPanel.setTitleAt(3, "Members");
            mainPanel.add(employeesPanel);
            mainPanel.remove(loginPanel);
            logoutButton.setVisible(true);
            welcomeLabel.setVisible(true); 
            
            updateServiceDirectoryTable();
            updateProviderTable();
            updateMemberTable();
         }
         else if(clientPrivileges == 1){
            mainPanel.add(serviceDirectoryPanel);
            mainPanel.setTitleAt(1, "Service Directory");
            mainPanel.add(providersPanel);
            mainPanel.setTitleAt(2, "Providers");
            mainPanel.add(membersPanel);
            mainPanel.setTitleAt(3, "Members");
            mainPanel.add(employeesPanel);
            mainPanel.setTitleAt(4, "Employees");
            mainPanel.add(requestReportPanel);
            mainPanel.setTitleAt(5, "Reports");
            mainPanel.remove(loginPanel);
            logoutButton.setVisible(true);
            welcomeLabel.setVisible(true); 

            updateServiceDirectoryTable();
            updateProviderTable();
            updateMemberTable();
            updateEmployeeTable();
         }
         else{
            mainPanel.remove(serviceDirectoryPanel);
            mainPanel.remove(providersPanel);
            mainPanel.remove(membersPanel);
            mainPanel.remove(employeesPanel);
            mainPanel.remove(requestReportPanel);
            mainPanel.add(loginPanel);
            mainPanel.setTitleAt(0, "Login");
            logoutButton.setVisible(false);
            welcomeLabel.setVisible(false);
         }
    }
    
    private void displayAlert(String message, String titleBar)
    {
        JOptionPane.showMessageDialog(null, message, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JTabbedPane();
        loginPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        instructionsLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        providersPanel = new javax.swing.JPanel();
        scrollPaneP = new javax.swing.JScrollPane();
        tableP = new javax.swing.JTable();
        providersLabel = new javax.swing.JLabel();
        refreshButtonP = new javax.swing.JButton();
        createButtonP = new javax.swing.JButton();
        editButtonP = new javax.swing.JButton();
        formPanelP = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        providerNumberInputP = new javax.swing.JTextField();
        nameInputP = new javax.swing.JTextField();
        addressInputP = new javax.swing.JTextField();
        cityInputP = new javax.swing.JTextField();
        zipInputP = new javax.swing.JTextField();
        stateInputP = new javax.swing.JTextField();
        submitInfoP = new javax.swing.JButton();
        passwordInputP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        emailAddressInputP = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        isActiveCheckBoxP = new javax.swing.JCheckBox();
        providerInfoLabel = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        membersPanel = new javax.swing.JPanel();
        scrollPanelM = new javax.swing.JScrollPane();
        tableM = new javax.swing.JTable();
        membersLabel = new javax.swing.JLabel();
        refreshButtonM = new javax.swing.JButton();
        createButtonM = new javax.swing.JButton();
        editButtonM = new javax.swing.JButton();
        formPanelM = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        memberNumberInputM = new javax.swing.JTextField();
        nameInputM = new javax.swing.JTextField();
        addressInputM = new javax.swing.JTextField();
        cityInputM = new javax.swing.JTextField();
        zipInputM = new javax.swing.JTextField();
        stateInputM = new javax.swing.JTextField();
        submitInfoM = new javax.swing.JButton();
        emailAddressInputM = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        isValidCheckBoxM = new javax.swing.JCheckBox();
        isActiveCheckBoxM = new javax.swing.JCheckBox();
        validityReasonInputM = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        memberInfoLabel = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        requestReportPanel = new javax.swing.JPanel();
        requestReportButton = new javax.swing.JButton();
        dateScrollPane = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        requestReportInstructions = new javax.swing.JLabel();
        numberInputR = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        datePickerR = new org.jdesktop.swingx.JXDatePicker();
        jLabel30 = new javax.swing.JLabel();
        requestReportInstructions1 = new javax.swing.JLabel();
        employeesPanel = new javax.swing.JPanel();
        employeesLabel = new javax.swing.JLabel();
        scrollPanelE = new javax.swing.JScrollPane();
        tableE = new javax.swing.JTable();
        refreshButtonE = new javax.swing.JButton();
        createButtonE = new javax.swing.JButton();
        editButtonE = new javax.swing.JButton();
        formPanelE = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        employeeNumberInputE = new javax.swing.JTextField();
        nameInputE = new javax.swing.JTextField();
        addressInputE = new javax.swing.JTextField();
        cityInputE = new javax.swing.JTextField();
        zipInputE = new javax.swing.JTextField();
        stateInputE = new javax.swing.JTextField();
        submitInfoE = new javax.swing.JButton();
        passwordInputE = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        emailAddressInputE = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        isActiveCheckBoxE = new javax.swing.JCheckBox();
        isManagerCheckBoxE = new javax.swing.JCheckBox();
        employeeInfoLabel = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        serviceDirectoryPanel = new javax.swing.JPanel();
        refreshButtonSD = new javax.swing.JButton();
        createButtonSD = new javax.swing.JButton();
        editButtonSD = new javax.swing.JButton();
        servicesLabel = new javax.swing.JLabel();
        formPanelSD = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        serviceCodeInputSD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameInputSD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        feeInputSD = new javax.swing.JTextField();
        submitButtonSD = new javax.swing.JButton();
        isActiveCheckboxSD = new javax.swing.JCheckBox();
        serviceInfoLabel = new javax.swing.JLabel();
        scrollPanelSD = new javax.swing.JScrollPane();
        tableSD = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        chocAnLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chocoholics Anonymous");
        setBackground(new java.awt.Color(230, 242, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(236, 245, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainPanel.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        mainPanel.setName(""); // NOI18N

        loginPanel.setBackground(new java.awt.Color(237, 245, 255));

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        loginButton.setText("Login");
        loginButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(198, 218, 243), null));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        instructionsLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        instructionsLabel.setText("Enter information to continue:");

        nameLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        nameLabel.setText("ID:");

        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        passwordLabel.setText("Password:");

        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        jLabel7.setText("Welcome To Chocoholics Anonymous!");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGap(0, 177, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(174, 174, 174))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameLabel)
                                    .addComponent(passwordLabel))
                                .addGap(18, 18, 18)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(instructionsLabel)
                                .addGap(1, 1, 1))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(533, 533, 533)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(instructionsLabel)
                .addGap(57, 57, 57)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(37, 37, 37)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(69, 69, 69)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );

        mainPanel.addTab("Log in", loginPanel);

        providersPanel.setBackground(new java.awt.Color(237, 245, 255));

        scrollPaneP.setBackground(new java.awt.Color(243, 237, 237));
        scrollPaneP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPaneP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneP.setViewportView(tableP);

        providersLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        providersLabel.setText("Providers:");

        refreshButtonP.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        refreshButtonP.setText("Refresh");
        refreshButtonP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refreshButtonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonPActionPerformed(evt);
            }
        });

        createButtonP.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        createButtonP.setText("Create");
        createButtonP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createButtonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonPActionPerformed(evt);
            }
        });

        editButtonP.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        editButtonP.setText("Edit");
        editButtonP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editButtonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonPActionPerformed(evt);
            }
        });

        formPanelP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Provider Number:");

        jLabel5.setText("Name:");

        jLabel6.setText("Street Address: ");

        jLabel8.setText("City:");

        jLabel9.setText("State:");

        jLabel10.setText("ZIP Code:");

        providerNumberInputP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerNumberInputPActionPerformed(evt);
            }
        });

        submitInfoP.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        submitInfoP.setText("SUBMIT");
        submitInfoP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitInfoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitInfoPActionPerformed(evt);
            }
        });

        jLabel11.setText("Password:");

        jLabel18.setText("Email Address");

        isActiveCheckBoxP.setText("Is Active");

        javax.swing.GroupLayout formPanelPLayout = new javax.swing.GroupLayout(formPanelP);
        formPanelP.setLayout(formPanelPLayout);
        formPanelPLayout.setHorizontalGroup(
            formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelPLayout.createSequentialGroup()
                        .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nameInputP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(providerNumberInputP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(passwordInputP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailAddressInputP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(139, 139, 139)
                        .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelPLayout.createSequentialGroup()
                                .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cityInputP, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(zipInputP, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitInfoP, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formPanelPLayout.createSequentialGroup()
                                .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(isActiveCheckBoxP)
                                    .addComponent(addressInputP, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(stateInputP, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel5))
                .addGap(95, 95, 95))
        );
        formPanelPLayout.setVerticalGroup(
            formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelPLayout.createSequentialGroup()
                        .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelPLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(1, 1, 1)
                                .addComponent(providerNumberInputP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelPLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, 0)
                                .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordInputP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityInputP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(submitInfoP))
                                .addGap(18, 18, 18)))
                        .addComponent(jLabel18)
                        .addGap(1, 1, 1)
                        .addComponent(emailAddressInputP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameInputP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isActiveCheckBoxP))
                        .addGap(55, 55, 55))
                    .addGroup(formPanelPLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(addressInputP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(formPanelPLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel9)
                                .addGap(30, 30, 30))
                            .addGroup(formPanelPLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(formPanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stateInputP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(zipInputP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(107, 107, 107))))
        );

        providerInfoLabel.setText("Provider Information:");

        jLabel31.setText("Select a Provider, then choose an option below:");

        javax.swing.GroupLayout providersPanelLayout = new javax.swing.GroupLayout(providersPanel);
        providersPanel.setLayout(providersPanelLayout);
        providersPanelLayout.setHorizontalGroup(
            providersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(providersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(providersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(formPanelP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(providersLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(providerInfoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, providersPanelLayout.createSequentialGroup()
                        .addComponent(scrollPaneP, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(providersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(providersPanelLayout.createSequentialGroup()
                                .addGroup(providersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(createButtonP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(refreshButtonP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editButtonP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96)))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        providersPanelLayout.setVerticalGroup(
            providersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, providersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(providersLabel)
                .addGap(0, 0, 0)
                .addGroup(providersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(providersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(49, 49, 49)
                        .addComponent(refreshButtonP)
                        .addGap(29, 29, 29)
                        .addComponent(createButtonP)
                        .addGap(29, 29, 29)
                        .addComponent(editButtonP))
                    .addComponent(scrollPaneP, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(providerInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formPanelP, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        providersLabel.getAccessibleContext().setAccessibleName("providersLabel ");

        mainPanel.addTab("Providers ", providersPanel);

        membersPanel.setBackground(new java.awt.Color(237, 245, 255));

        scrollPanelM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPanelM.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanelM.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        tableM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPanelM.setViewportView(tableM);

        membersLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        membersLabel.setText("Members:");

        refreshButtonM.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        refreshButtonM.setText("Refresh");
        refreshButtonM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refreshButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonMActionPerformed(evt);
            }
        });

        createButtonM.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        createButtonM.setText("Create");
        createButtonM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonMActionPerformed(evt);
            }
        });

        editButtonM.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        editButtonM.setText("Edit");
        editButtonM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonMActionPerformed(evt);
            }
        });

        formPanelM.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("Member Number:");

        jLabel13.setText("Name:");

        jLabel14.setText("Street Address: ");

        jLabel15.setText("City:");

        jLabel16.setText("State:");

        jLabel17.setText("ZIP Code:");

        memberNumberInputM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNumberInputMActionPerformed(evt);
            }
        });

        submitInfoM.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        submitInfoM.setText("SUBMIT");
        submitInfoM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitInfoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitInfoMActionPerformed(evt);
            }
        });

        jLabel25.setText("Email Address:");

        isValidCheckBoxM.setText("Is Valid");

        isActiveCheckBoxM.setText("Is Active");

        validityReasonInputM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validityReasonInputMActionPerformed(evt);
            }
        });

        jLabel26.setText("Validity Reason:");

        javax.swing.GroupLayout formPanelMLayout = new javax.swing.GroupLayout(formPanelM);
        formPanelM.setLayout(formPanelMLayout);
        formPanelMLayout.setHorizontalGroup(
            formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelMLayout.createSequentialGroup()
                        .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(memberNumberInputM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(nameInputM, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(emailAddressInputM, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressInputM, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(116, 116, 116)
                        .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelMLayout.createSequentialGroup()
                                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPanelMLayout.createSequentialGroup()
                                        .addComponent(isValidCheckBoxM)
                                        .addGap(26, 26, 26)
                                        .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(validityReasonInputM, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26)))
                                    .addComponent(jLabel15)
                                    .addComponent(isActiveCheckBoxM))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(formPanelMLayout.createSequentialGroup()
                                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cityInputM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(formPanelMLayout.createSequentialGroup()
                                        .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(formPanelMLayout.createSequentialGroup()
                                                .addComponent(stateInputM, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelMLayout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(168, 168, 168)))
                                        .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(zipInputM, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitInfoM, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))))
                    .addGroup(formPanelMLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        formPanelMLayout.setVerticalGroup(
            formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelMLayout.createSequentialGroup()
                        .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(0, 0, 0)
                        .addComponent(memberNumberInputM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cityInputM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelMLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formPanelMLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, 0)
                                .addComponent(nameInputM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formPanelMLayout.createSequentialGroup()
                                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(1, 1, 1)
                                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stateInputM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(zipInputM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelMLayout.createSequentialGroup()
                                .addGap(0, 58, Short.MAX_VALUE)
                                .addComponent(jLabel26)
                                .addGap(18, 82, Short.MAX_VALUE))
                            .addGroup(formPanelMLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(2, 2, 2)
                                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailAddressInputM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(isActiveCheckBoxM))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addGap(0, 0, 0)
                                .addGroup(formPanelMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addressInputM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(isValidCheckBoxM)
                                    .addComponent(validityReasonInputM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(formPanelMLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(submitInfoM)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        memberInfoLabel.setText("Member Information:");

        jLabel32.setText("Select a Member, then choose an option below:");

        javax.swing.GroupLayout membersPanelLayout = new javax.swing.GroupLayout(membersPanel);
        membersPanel.setLayout(membersPanelLayout);
        membersPanelLayout.setHorizontalGroup(
            membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(membersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(membersLabel)
                    .addComponent(memberInfoLabel)
                    .addGroup(membersPanelLayout.createSequentialGroup()
                        .addComponent(scrollPanelM, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(membersPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel32))
                            .addGroup(membersPanelLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(refreshButtonM, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editButtonM, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(createButtonM, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(formPanelM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        membersPanelLayout.setVerticalGroup(
            membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, membersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(membersLabel)
                .addGroup(membersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(membersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(49, 49, 49)
                        .addComponent(refreshButtonM)
                        .addGap(29, 29, 29)
                        .addComponent(createButtonM)
                        .addGap(29, 29, 29)
                        .addComponent(editButtonM))
                    .addComponent(scrollPanelM, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(memberInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formPanelM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        mainPanel.addTab("Members", membersPanel);

        requestReportPanel.setBackground(new java.awt.Color(237, 245, 255));

        requestReportButton.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        requestReportButton.setText("Request Report");
        requestReportButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        requestReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestReportButtonActionPerformed(evt);
            }
        });

        jList1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Member Report", "Provider Report", "Summary Report" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setToolTipText("");
        dateScrollPane.setViewportView(jList1);

        requestReportInstructions.setText("Choose a date to request a report for:");

        jLabel29.setText("Member/Provider Number:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Please fill out the following fields to request a report:");

        requestReportInstructions1.setText("Choose the type of report:");

        javax.swing.GroupLayout requestReportPanelLayout = new javax.swing.GroupLayout(requestReportPanel);
        requestReportPanel.setLayout(requestReportPanelLayout);
        requestReportPanelLayout.setHorizontalGroup(
            requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestReportPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(requestReportPanelLayout.createSequentialGroup()
                        .addGroup(requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(requestReportInstructions)
                            .addComponent(jLabel29)
                            .addComponent(requestReportInstructions1))
                        .addGap(21, 21, 21)
                        .addGroup(requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(numberInputR)
                                .addComponent(datePickerR, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                            .addComponent(dateScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(requestReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(731, Short.MAX_VALUE))
        );
        requestReportPanelLayout.setVerticalGroup(
            requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, requestReportPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel30)
                .addGap(57, 57, 57)
                .addGroup(requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestReportInstructions)
                    .addComponent(datePickerR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestReportInstructions1)
                    .addComponent(dateScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(requestReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberInputR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(47, 47, 47)
                .addComponent(requestReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(378, Short.MAX_VALUE))
        );

        mainPanel.addTab("Reports", requestReportPanel);

        employeesPanel.setBackground(new java.awt.Color(237, 245, 255));

        employeesLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        employeesLabel.setText("Employees:");

        scrollPanelE.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPanelE.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanelE.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        tableE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPanelE.setViewportView(tableE);

        refreshButtonE.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        refreshButtonE.setText("Refresh");
        refreshButtonE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refreshButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonEActionPerformed(evt);
            }
        });

        createButtonE.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        createButtonE.setText("Create");
        createButtonE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonEActionPerformed(evt);
            }
        });

        editButtonE.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        editButtonE.setText("Edit");
        editButtonE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonEActionPerformed(evt);
            }
        });

        formPanelE.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setText("Employee Number:");

        jLabel20.setText("Name:");

        jLabel21.setText("Street Address: ");

        jLabel22.setText("City:");

        jLabel23.setText("State:");

        jLabel24.setText("ZIP Code:");

        employeeNumberInputE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNumberInputEActionPerformed(evt);
            }
        });

        submitInfoE.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        submitInfoE.setText("SUBMIT");
        submitInfoE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitInfoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitInfoEActionPerformed(evt);
            }
        });

        jLabel27.setText("Password:");

        jLabel28.setText("Email Address:");

        isActiveCheckBoxE.setText("Is Active");

        isManagerCheckBoxE.setText("Is Manager");

        javax.swing.GroupLayout formPanelELayout = new javax.swing.GroupLayout(formPanelE);
        formPanelE.setLayout(formPanelELayout);
        formPanelELayout.setHorizontalGroup(
            formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel20)
                        .addComponent(jLabel19)
                        .addComponent(passwordInputE, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addComponent(nameInputE)
                        .addComponent(employeeNumberInputE))
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(emailAddressInputE, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(186, 186, 186)
                .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formPanelELayout.createSequentialGroup()
                            .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addComponent(stateInputE, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(formPanelELayout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(isManagerCheckBoxE))
                                .addGroup(formPanelELayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(zipInputE, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(formPanelELayout.createSequentialGroup()
                            .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(formPanelELayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(formPanelELayout.createSequentialGroup()
                                    .addComponent(cityInputE, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addGap(264, 264, 264)))
                            .addComponent(submitInfoE, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(88, 88, 88)))
                    .addGroup(formPanelELayout.createSequentialGroup()
                        .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(addressInputE, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isActiveCheckBoxE))
                        .addGap(220, 220, 220))))
        );
        formPanelELayout.setVerticalGroup(
            formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelELayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, 0)
                        .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeNumberInputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressInputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formPanelELayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, 0)
                        .addComponent(passwordInputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addGap(0, 0, 0)
                        .addComponent(nameInputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formPanelELayout.createSequentialGroup()
                        .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelELayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cityInputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(submitInfoE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(0, 0, 0)
                        .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stateInputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zipInputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addGap(0, 0, 0)
                .addGroup(formPanelELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAddressInputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isActiveCheckBoxE)
                    .addComponent(isManagerCheckBoxE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        employeeInfoLabel.setText("Employee Information:");

        jLabel33.setText("Select a Employee, then choose an option below:");

        javax.swing.GroupLayout employeesPanelLayout = new javax.swing.GroupLayout(employeesPanel);
        employeesPanel.setLayout(employeesPanelLayout);
        employeesPanelLayout.setHorizontalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeesPanelLayout.createSequentialGroup()
                        .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeesLabel)
                            .addGroup(employeesPanelLayout.createSequentialGroup()
                                .addComponent(scrollPanelE, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(employeesPanelLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel33))
                                    .addGroup(employeesPanelLayout.createSequentialGroup()
                                        .addGap(139, 139, 139)
                                        .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(createButtonE, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(refreshButtonE, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(editButtonE, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(employeesPanelLayout.createSequentialGroup()
                        .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeInfoLabel)
                            .addComponent(formPanelE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        employeesPanelLayout.setVerticalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeesLabel)
                .addGap(0, 0, 0)
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(employeesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(49, 49, 49)
                        .addComponent(refreshButtonE)
                        .addGap(29, 29, 29)
                        .addComponent(createButtonE)
                        .addGap(29, 29, 29)
                        .addComponent(editButtonE))
                    .addComponent(scrollPanelE, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formPanelE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        mainPanel.addTab("Employees", employeesPanel);

        serviceDirectoryPanel.setBackground(new java.awt.Color(236, 245, 255));
        serviceDirectoryPanel.setName("Service Directory "); // NOI18N

        refreshButtonSD.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        refreshButtonSD.setText("Refresh");
        refreshButtonSD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refreshButtonSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonSDActionPerformed(evt);
            }
        });

        createButtonSD.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        createButtonSD.setText("Create");
        createButtonSD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createButtonSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonSDActionPerformed(evt);
            }
        });

        editButtonSD.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        editButtonSD.setText("Edit");
        editButtonSD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editButtonSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonSDActionPerformed(evt);
            }
        });

        servicesLabel.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        servicesLabel.setText("Services:");

        formPanelSD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Service Number:");

        jLabel2.setText("Service Name:");

        nameInputSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputSDActionPerformed(evt);
            }
        });

        jLabel3.setText("Service Fee:");

        submitButtonSD.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        submitButtonSD.setText("SUBMIT");
        submitButtonSD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submitButtonSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonSDActionPerformed(evt);
            }
        });

        isActiveCheckboxSD.setText("Is Active");

        javax.swing.GroupLayout formPanelSDLayout = new javax.swing.GroupLayout(formPanelSD);
        formPanelSD.setLayout(formPanelSDLayout);
        formPanelSDLayout.setHorizontalGroup(
            formPanelSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelSDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelSDLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(serviceCodeInputSD, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(formPanelSDLayout.createSequentialGroup()
                        .addGroup(formPanelSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(formPanelSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameInputSD, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(feeInputSD, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(isActiveCheckboxSD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(submitButtonSD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        formPanelSDLayout.setVerticalGroup(
            formPanelSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelSDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(serviceCodeInputSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(formPanelSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameInputSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(submitButtonSD)
                    .addComponent(isActiveCheckboxSD))
                .addGap(25, 25, 25)
                .addGroup(formPanelSDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feeInputSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        serviceInfoLabel.setText("Service Information:");

        scrollPanelSD.setBackground(new java.awt.Color(242, 245, 247));
        scrollPanelSD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPanelSD.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanelSD.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        scrollPanelSD.setOpaque(false);

        tableSD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPanelSD.setViewportView(tableSD);

        jLabel34.setText("Select a Employee, then choose an option below:");

        javax.swing.GroupLayout serviceDirectoryPanelLayout = new javax.swing.GroupLayout(serviceDirectoryPanel);
        serviceDirectoryPanel.setLayout(serviceDirectoryPanelLayout);
        serviceDirectoryPanelLayout.setHorizontalGroup(
            serviceDirectoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviceDirectoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(serviceDirectoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serviceDirectoryPanelLayout.createSequentialGroup()
                        .addComponent(scrollPanelSD, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(serviceDirectoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(serviceDirectoryPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel34)
                                .addContainerGap(67, Short.MAX_VALUE))
                            .addGroup(serviceDirectoryPanelLayout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addGroup(serviceDirectoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editButtonSD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(createButtonSD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(refreshButtonSD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(serviceDirectoryPanelLayout.createSequentialGroup()
                        .addGroup(serviceDirectoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servicesLabel)
                            .addComponent(formPanelSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serviceInfoLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        serviceDirectoryPanelLayout.setVerticalGroup(
            serviceDirectoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serviceDirectoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(servicesLabel)
                .addGap(1, 1, 1)
                .addGroup(serviceDirectoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(serviceDirectoryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(49, 49, 49)
                        .addComponent(refreshButtonSD)
                        .addGap(29, 29, 29)
                        .addComponent(createButtonSD)
                        .addGap(29, 29, 29)
                        .addComponent(editButtonSD))
                    .addComponent(scrollPanelSD, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(serviceInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formPanelSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        servicesLabel.getAccessibleContext().setAccessibleName("Services ");

        mainPanel.addTab("Service Directory ", serviceDirectoryPanel);

        titlePanel.setBackground(new java.awt.Color(236, 245, 255));

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        logoutButton.setText("Log out");
        logoutButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        welcomeLabel.setText("Welcome, ");

        chocAnLabel.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        chocAnLabel.setText("Chocoholics Anonymous");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chocAnLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(chocAnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonSDActionPerformed
        setServiceFieldsEditable(true);
        
        clearDataSD();
        
        currentSDCommand = 0;
    }//GEN-LAST:event_createButtonSDActionPerformed

    private void refreshButtonSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonSDActionPerformed
        updateServiceDirectoryTable();
    }//GEN-LAST:event_refreshButtonSDActionPerformed

    private void refreshButtonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonPActionPerformed
        updateProviderTable();
    }//GEN-LAST:event_refreshButtonPActionPerformed

    private void createButtonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonPActionPerformed
        setProviderFieldsEditable(true);
        
        clearDataP();
        
        currentPCommand = 0;
    }//GEN-LAST:event_createButtonPActionPerformed

    private void refreshButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonMActionPerformed
        updateMemberTable();
    }//GEN-LAST:event_refreshButtonMActionPerformed

    private void createButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonMActionPerformed
        setMemberFieldsEditable(true);
        
        clearDataM();
        
        currentMCommand = 0;
    }//GEN-LAST:event_createButtonMActionPerformed

    private void refreshButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonEActionPerformed
        updateEmployeeTable();
    }//GEN-LAST:event_refreshButtonEActionPerformed

    private void createButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonEActionPerformed
        setEmployeeFieldsEditable(true);
        
        clearDataE();
        
        currentECommand = 0;
    }//GEN-LAST:event_createButtonEActionPerformed

    private void submitButtonSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonSDActionPerformed
        Service service = new Service();
        service.serviceNumber = serviceCodeInputSD.getText();
        service.name = nameInputSD.getText();
        boolean doubleConverted = false;
        try
        {
            service.fee = Double.parseDouble(feeInputSD.getText());
            doubleConverted = true;
        } catch (Exception e)
        {
            doubleConverted = false;
        }
        service.isActive = isActiveCheckboxSD.isSelected();
        
        if (service.verifyData() && doubleConverted)
        {
            int returnValue = -1;
            
            try
            {
                if (currentSDCommand == 0)
                {
                    returnValue = employeeTerminal.insertService(service);
                }
                else if (currentSDCommand == 1)
                {
                    returnValue = employeeTerminal.updateService(service);
                }
                
                if (returnValue == 0)
                {
                    displayAlert("Entry Successfully Inserted/Edited", "Submit Service Alert");
                    setServiceFieldsEditable(false);
                    currentSDCommand = -1;
                    clearDataSD();
                }
                else if (returnValue == 1)
                {
                    displayAlert("Connection to database failed at server", "Submit Service Alert");
                }
                else if (returnValue == 4)
                {
                    displayAlert("Invalid Data", "Submit Service Alert");
                }
                
            } catch(Exception e)
            {
                displayAlert("Connection to server failed", "Submit Service Alert");
            }
            
        } else
        {
            displayAlert("Invalid Input", "Submit Service Alert");
        }
    }//GEN-LAST:event_submitButtonSDActionPerformed

    private void nameInputSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputSDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputSDActionPerformed

    private void providerNumberInputPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerNumberInputPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_providerNumberInputPActionPerformed

    private void memberNumberInputMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberNumberInputMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberNumberInputMActionPerformed

    private void editButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonMActionPerformed
        setMemberFieldsEditable(true);
        
        int row = tableM.getSelectedRow();
        memberNumberInputM.setText((String) tableM.getValueAt(row, 0));
        memberNumberInputM.setEditable(false);
        nameInputM.setText((String) tableM.getValueAt(row, 1));
        emailAddressInputM.setText((String) tableM.getValueAt(row, 2));
        addressInputM.setText((String) tableM.getValueAt(row, 3));
        cityInputM.setText((String) tableM.getValueAt(row, 4));
        stateInputM.setText((String) tableM.getValueAt(row, 5));
        zipInputM.setText((String) tableM.getValueAt(row, 6));
        isValidCheckBoxM.setSelected((Boolean) tableM.getValueAt(row, 7));
        validityReasonInputM.setText((String) tableM.getValueAt(row, 8));
        isActiveCheckBoxM.setSelected((Boolean) tableM.getValueAt(row, 9));
        
        currentMCommand = 1;
    }//GEN-LAST:event_editButtonMActionPerformed

    private void employeeNumberInputEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNumberInputEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeNumberInputEActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String employeeNumber = nameInput.getText();
        String password = passwordInput.getText();
        
        clientPrivileges = employeeTerminal.login(employeeNumber, password);
        
        if (clientPrivileges == 0 || clientPrivileges == 1)
        {
            updateTabs();
            nameInput.setText(null);
            passwordInput.setText(null);
            
            setServiceFieldsEditable(false);
            setProviderFieldsEditable(false);
            setMemberFieldsEditable(false);
            setEmployeeFieldsEditable(false);
        }
        else if (clientPrivileges == 2)
        {
            displayAlert("Invalid login credentials", "Login Error");
        }
        else if (clientPrivileges == 3)
        {
            displayAlert("Database down", "Login Error");
        }
        else
        {
            displayAlert("Cannot connect to server", "Login Error");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        employeeTerminal.disconnect();
        
        clientPrivileges = -1;
        
        clearDataSD();
        clearDataP();
        clearDataM();
        clearDataE();
        
        updateTabs();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void editButtonSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonSDActionPerformed
        setServiceFieldsEditable(true);
        
        int entry = tableSD.getSelectedRow();
        serviceCodeInputSD.setText((String) tableSD.getValueAt(entry, 0));
        serviceCodeInputSD.setEditable(false);
        nameInputSD.setText((String) tableSD.getValueAt(entry, 1));
        feeInputSD.setText(Double.toString((Double) tableSD.getValueAt(entry, 2)));
        isActiveCheckboxSD.setSelected((Boolean) tableSD.getValueAt(entry, 3));
        
        currentSDCommand = 1;
    }//GEN-LAST:event_editButtonSDActionPerformed

    private void validityReasonInputMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validityReasonInputMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_validityReasonInputMActionPerformed

    private void editButtonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonPActionPerformed
        setProviderFieldsEditable(true);
        
        int row = tableP.getSelectedRow();
        providerNumberInputP.setText((String) tableP.getValueAt(row, 0));
        providerNumberInputP.setEditable(false);
        passwordInputP.setText((String) tableP.getValueAt(row, 1));
        nameInputP.setText((String) tableP.getValueAt(row, 2));
        emailAddressInputP.setText((String) tableP.getValueAt(row, 3));
        addressInputP.setText((String) tableP.getValueAt(row, 4));
        cityInputP.setText((String) tableP.getValueAt(row, 5));
        stateInputP.setText((String) tableP.getValueAt(row, 6));
        zipInputP.setText((String) tableP.getValueAt(row, 7));
        isActiveCheckBoxP.setSelected((Boolean) tableP.getValueAt(row, 8));
        
        currentPCommand = 1;
    }//GEN-LAST:event_editButtonPActionPerformed

    private void submitInfoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitInfoPActionPerformed
        Provider provider = new Provider();
        provider.providerNumber = providerNumberInputP.getText();
        provider.password = passwordInputP.getText();
        provider.name = nameInputP.getText();
        provider.emailAddress = emailAddressInputP.getText();
        provider.streetAddress = addressInputP.getText();
        provider.city = cityInputP.getText();
        provider.state = stateInputP.getText();
        provider.zipCode = zipInputP.getText();
        provider.isActive = isActiveCheckBoxP.isSelected();
        
        if (provider.verifyData())
        {
            int returnValue = -1;
            
            try
            {
                if (currentPCommand == 0)
                {
                    returnValue = employeeTerminal.insertProvider(provider);
                }
                else if (currentPCommand == 1)
                {
                    returnValue = employeeTerminal.updateProvider(provider);
                }
                
                if (returnValue == 0)
                {
                    displayAlert("Entry Successfully Inserted/Edited", "Submit Provider Alert");
                    setProviderFieldsEditable(false);
                    currentPCommand = -1;
                    clearDataP();
                }
                else if (returnValue == 1)
                {
                    displayAlert("Connection to database failed at server", "Submit Provider Alert");
                }
                else if (returnValue == 4)
                {
                    displayAlert("Invalid Data", "Submit Provider Alert");
                }
                
            } catch(Exception e)
            {
                displayAlert("Connection to server failed", "Submit Provider Alert");
            }
            
        } else
        {
            displayAlert("Invalid Input", "Submit Provider Alert");
        }
    }//GEN-LAST:event_submitInfoPActionPerformed

    private void submitInfoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitInfoMActionPerformed
        Member member = new Member();
        member.memberNumber = memberNumberInputM.getText();
        member.name = nameInputM.getText();
        member.emailAddress = emailAddressInputM.getText();
        member.streetAddress = addressInputM.getText();
        member.city = cityInputM.getText();
        member.state = stateInputM.getText();
        member.zipCode = zipInputM.getText();
        member.isValid = isValidCheckBoxM.isSelected();
        member.validityReason = validityReasonInputM.getText();
        member.isActive = isActiveCheckBoxM.isSelected();
        
        if (member.verifyData())
        {
            int returnValue = -1;
            
            try
            {
                if (currentMCommand == 0)
                {
                    returnValue = employeeTerminal.insertMember(member);
                }
                else if (currentMCommand == 1)
                {
                    returnValue = employeeTerminal.updateMember(member);
                }
                
                if (returnValue == 0)
                {
                    displayAlert("Entry Successfully Inserted/Edited", "Submit Member Alert");
                    setMemberFieldsEditable(false);
                    currentMCommand = -1;
                    clearDataM();
                }
                else if (returnValue == 1)
                {
                    displayAlert("Connection to database failed at server", "Submit Member Alert");
                }
                else if (returnValue == 4)
                {
                    displayAlert("Invalid Data", "Submit Member Alert");
                }
                
            } catch(Exception e)
            {
                displayAlert("Connection to server failed", "Submit Member Alert");
            }
            
        } else
        {
            displayAlert("Invalid Input", "Submit Member Alert");
        }
    }//GEN-LAST:event_submitInfoMActionPerformed

    private void editButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonEActionPerformed
        setEmployeeFieldsEditable(true);
        
        int row = tableE.getSelectedRow();
        employeeNumberInputE.setText((String) tableE.getValueAt(row, 0));
        employeeNumberInputE.setEditable(false);
        passwordInputE.setText((String) tableE.getValueAt(row, 1));
        nameInputE.setText((String) tableE.getValueAt(row, 2));
        emailAddressInputE.setText((String) tableE.getValueAt(row, 3));
        addressInputE.setText((String) tableE.getValueAt(row, 4));
        cityInputE.setText((String) tableE.getValueAt(row, 5));
        stateInputE.setText((String) tableE.getValueAt(row, 6));
        zipInputE.setText((String) tableE.getValueAt(row, 7));
        isActiveCheckBoxE.setSelected((Boolean) tableE.getValueAt(row, 8));
        isManagerCheckBoxE.setSelected((Boolean) tableE.getValueAt(row, 9));
        
        currentECommand = 1;
    }//GEN-LAST:event_editButtonEActionPerformed

    private void submitInfoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitInfoEActionPerformed
        Employee employee = new Employee();
        employee.employeeNumber = employeeNumberInputE.getText();
        employee.password = passwordInputE.getText();
        employee.name = nameInputE.getText();
        employee.emailAddress = emailAddressInputE.getText();
        employee.streetAddress = addressInputE.getText();
        employee.city = cityInputE.getText();
        employee.state = stateInputE.getText();
        employee.zipCode = zipInputE.getText();
        employee.isActive = isActiveCheckBoxE.isSelected();
        employee.isManager = isManagerCheckBoxE.isSelected();
        
        if (employee.verifyData())
        {
            int returnValue = -1;
            
            try
            {
                if (currentECommand == 0)
                {
                    returnValue = employeeTerminal.insertEmployee(employee);
                }
                else if (currentECommand == 1)
                {
                    returnValue = employeeTerminal.updateEmployee(employee);
                }
                
                if (returnValue == 0)
                {
                    displayAlert("Entry Successfully Inserted/Edited", "Submit Employee Alert");
                    setEmployeeFieldsEditable(false);
                    currentECommand = -1;
                    clearDataE();
                }
                else if (returnValue == 1)
                {
                    displayAlert("Connection to database failed at server", "Submit Employee Alert");
                }
                else if (returnValue == 4)
                {
                    displayAlert("Invalid Data", "Submit Employee Alert");
                }
                
            } catch(Exception e)
            {
                displayAlert("Connection to server failed", "Submit Employee Alert");
            }
            
        } else
        {
            displayAlert("Invalid Input", "Submit Employee Alert");
        }
    }//GEN-LAST:event_submitInfoEActionPerformed

    private void requestReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestReportButtonActionPerformed
        LocalDateTime endDateTime = LocalDateTime.ofInstant(datePickerR.getDate().toInstant(), ZoneId.systemDefault());
        
        String number = numberInputR.getText();
        
        int returnValue = -1;
        
        if (jList1.getSelectedValue() == "Member Report")
        {
            try {
                returnValue = employeeTerminal.requestMemberReport(number, endDateTime);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (jList1.getSelectedValue() == "Provider Report")
        {
            try {
                returnValue = employeeTerminal.requestProviderReport(number, endDateTime);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (jList1.getSelectedValue() == "Summary Report")
        {
            try {
                returnValue = employeeTerminal.requestSummaryReport(endDateTime);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        if (returnValue == 0)
        {
            displayAlert("Report successfully created.", "Report Request Alert");
        }
        else if (returnValue == 1)
        {
            displayAlert("No bills in the time period to report.", "Report Request Alert");
        }
        else if (returnValue == 2)
        {
            displayAlert("Provider/Member number not found.", "Report Request Alert");
        }
        else
        {
            displayAlert("Missing Input. Please fill all necessary fields.", "Report Request Alert");
        }
    }//GEN-LAST:event_requestReportButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
         
            public void run() {
                new EmployeeTerminal().setVisible(true);
                           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressInputE;
    private javax.swing.JTextField addressInputM;
    private javax.swing.JTextField addressInputP;
    private javax.swing.JLabel chocAnLabel;
    private javax.swing.JTextField cityInputE;
    private javax.swing.JTextField cityInputM;
    private javax.swing.JTextField cityInputP;
    private javax.swing.JButton createButtonE;
    private javax.swing.JButton createButtonM;
    private javax.swing.JButton createButtonP;
    private javax.swing.JButton createButtonSD;
    private org.jdesktop.swingx.JXDatePicker datePickerR;
    private javax.swing.JScrollPane dateScrollPane;
    private javax.swing.JButton editButtonE;
    private javax.swing.JButton editButtonM;
    private javax.swing.JButton editButtonP;
    private javax.swing.JButton editButtonSD;
    private javax.swing.JTextField emailAddressInputE;
    private javax.swing.JTextField emailAddressInputM;
    private javax.swing.JTextField emailAddressInputP;
    private javax.swing.JLabel employeeInfoLabel;
    private javax.swing.JTextField employeeNumberInputE;
    private javax.swing.JLabel employeesLabel;
    private javax.swing.JPanel employeesPanel;
    private javax.swing.JTextField feeInputSD;
    private javax.swing.JPanel formPanelE;
    private javax.swing.JPanel formPanelM;
    private javax.swing.JPanel formPanelP;
    private javax.swing.JPanel formPanelSD;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JCheckBox isActiveCheckBoxE;
    private javax.swing.JCheckBox isActiveCheckBoxM;
    private javax.swing.JCheckBox isActiveCheckBoxP;
    private javax.swing.JCheckBox isActiveCheckboxSD;
    private javax.swing.JCheckBox isManagerCheckBoxE;
    private javax.swing.JCheckBox isValidCheckBoxM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JLabel memberInfoLabel;
    private javax.swing.JTextField memberNumberInputM;
    private javax.swing.JLabel membersLabel;
    private javax.swing.JPanel membersPanel;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField nameInputE;
    private javax.swing.JTextField nameInputM;
    private javax.swing.JTextField nameInputP;
    private javax.swing.JTextField nameInputSD;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField numberInputR;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JTextField passwordInputE;
    private javax.swing.JTextField passwordInputP;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel providerInfoLabel;
    private javax.swing.JTextField providerNumberInputP;
    private javax.swing.JLabel providersLabel;
    private javax.swing.JPanel providersPanel;
    private javax.swing.JButton refreshButtonE;
    private javax.swing.JButton refreshButtonM;
    private javax.swing.JButton refreshButtonP;
    private javax.swing.JButton refreshButtonSD;
    private javax.swing.JButton requestReportButton;
    private javax.swing.JLabel requestReportInstructions;
    private javax.swing.JLabel requestReportInstructions1;
    private javax.swing.JPanel requestReportPanel;
    private javax.swing.JScrollPane scrollPaneP;
    private javax.swing.JScrollPane scrollPanelE;
    private javax.swing.JScrollPane scrollPanelM;
    private javax.swing.JScrollPane scrollPanelSD;
    private javax.swing.JTextField serviceCodeInputSD;
    private javax.swing.JPanel serviceDirectoryPanel;
    private javax.swing.JLabel serviceInfoLabel;
    private javax.swing.JLabel servicesLabel;
    private javax.swing.JTextField stateInputE;
    private javax.swing.JTextField stateInputM;
    private javax.swing.JTextField stateInputP;
    private javax.swing.JButton submitButtonSD;
    private javax.swing.JButton submitInfoE;
    private javax.swing.JButton submitInfoM;
    private javax.swing.JButton submitInfoP;
    private javax.swing.JTable tableE;
    private javax.swing.JTable tableM;
    private javax.swing.JTable tableP;
    private javax.swing.JTable tableSD;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField validityReasonInputM;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JTextField zipInputE;
    private javax.swing.JTextField zipInputM;
    private javax.swing.JTextField zipInputP;
    // End of variables declaration//GEN-END:variables

   
}
