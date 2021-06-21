
package loanassistance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.border.LineBorder;
public class LoanAssistant extends JFrame
{
JLabel balanceLabel = new JLabel();

JTextField balanceTextField = new JTextField();

JLabel interestLabel = new JLabel();

JTextField interestTextField = new JTextField();

JLabel monthsLabel = new JLabel();

JTextField monthsTextField = new JTextField();

JLabel paymentLabel = new JLabel();

JTextField paymentTextField = new JTextField(); JButton

computeButton = new JButton();

JButton newLoanButton = new JButton();
JButton monthsButton = new JButton();


JButton paymentButton = new JButton();

JLabel analysisLabel = new JLabel();

JTextArea analysisTextArea = new JTextArea();
JButton exitButton =new JButton();


Font myFont = new Font("Arial", Font.PLAIN, 16);


Color lightYellow = new Color(255, 255, 128); 
boolean computePayment;
private final JScrollPane scrollPane = new JScrollPane();

public static void main(String args[]){
// create frame
new LoanAssistant().show();
}

public LoanAssistant()
{
	getContentPane().setBackground(new Color(95, 158, 160));
	getContentPane().setEnabled(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
// frame constructor
setTitle("My Loan Assistant");
setResizable(true);
addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent evt)
{
exitForm(evt);
}
});
GridBagLayout gridBagLayout = new GridBagLayout();
gridBagLayout.rowHeights = new int[]{69, 79, 60, 66, 138, 226};
gridBagLayout.columnWidths = new int[]{227, 182, 108, 407};
getContentPane().setLayout(gridBagLayout);
GridBagConstraints gridConstraints;


balanceLabel.setText("Loan Balance");
balanceLabel.setFont(myFont);
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx =0;
gridConstraints.gridy = 0;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 5, 5);
getContentPane().add(balanceLabel, gridConstraints);
balanceTextField.setPreferredSize(new Dimension(100, 25));
balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
balanceTextField.setFont(myFont);

gridConstraints = new GridBagConstraints();
gridConstraints.gridx =1;
gridConstraints.gridy = 0;
gridConstraints.insets = new Insets(10, 10, 5, 10);
getContentPane().add(balanceTextField, gridConstraints);
balanceTextField.addActionListener(new ActionListener () {
public void actionPerformed(ActionEvent e){
balanceTextFieldActionPerformed(e);
}
});

interestLabel.setText("Interest Rate");
interestLabel.setFont(myFont);
gridConstraints = new GridBagConstraints(); gridConstraints.gridx =
0;
gridConstraints.gridy = 1;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 5, 5);
getContentPane().add(interestLabel, gridConstraints);
interestTextField.setPreferredSize(new Dimension(100, 25));
interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
interestTextField.setFont(myFont);
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx =1;
gridConstraints.gridy = 1;
gridConstraints.insets = new Insets(10, 10, 5, 10);
getContentPane().add(interestTextField, gridConstraints);
interestTextField.addActionListener(new ActionListener () {
public void actionPerformed(ActionEvent e)
{
interestTextFieldActionPerformed(e);
}
});
GridBagConstraints gbc_scrollPane = new GridBagConstraints();
gbc_scrollPane.fill = GridBagConstraints.BOTH;
gbc_scrollPane.gridheight = 4;
gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
gbc_scrollPane.gridx = 3;
gbc_scrollPane.gridy = 1;
getContentPane().add(scrollPane, gbc_scrollPane);
scrollPane.setViewportView(analysisTextArea);
analysisTextArea.setPreferredSize(new Dimension(350, 300));
analysisTextArea.setFocusable(false);
analysisTextArea.setBorder(new LineBorder(new Color(0, 0, 0), 3));
analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 15));
analysisTextArea.setEditable(false);
analysisTextArea.setBackground(Color.WHITE);
monthsLabel.setText("Number of Payments");
monthsLabel.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx =0;
gridConstraints.gridy = 2;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 5, 5);
getContentPane().add(monthsLabel, gridConstraints);
monthsTextField.setPreferredSize(new Dimension(100, 25));
monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
monthsTextField.setFont(myFont);
gridConstraints = new GridBagConstraints(); gridConstraints.gridx =1;
gridConstraints.gridy = 2;
gridConstraints.insets = new Insets(10, 10, 5, 10);
getContentPane().add(monthsTextField, gridConstraints);
monthsTextField.addActionListener(new ActionListener () {
public void actionPerformed(ActionEvent e)
{monthsTextFieldActionPerformed(e);
}
});


paymentLabel.setText("Monthly Payment");
paymentLabel.setFont(myFont);
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx =0;
gridConstraints.gridy = 3;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 5, 5);
getContentPane().add(paymentLabel, gridConstraints);
paymentTextField.setPreferredSize(new Dimension(100, 25));
paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
paymentTextField.setFont(myFont);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx =1;
gridConstraints.gridy = 3;
gridConstraints.insets = new Insets(10, 10, 5, 10);
getContentPane().add(paymentTextField, gridConstraints);
paymentTextField.addActionListener(new ActionListener () {
public void actionPerformed(ActionEvent e)
{
paymentTextFieldActionPerformed(e);
}
});

 computeButton.setText("Compute Monthly Payment");
 gridConstraints = new GridBagConstraints(); gridConstraints.gridx =0;
 gridConstraints.gridy = 4;gridConstraints.gridwidth = 2;
 gridConstraints.insets = new Insets(10, 0, 5, 5);
 getContentPane().add(computeButton, gridConstraints);
 computeButton.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e)
{
computeButtonActionPerformed(e);
}
});
newLoanButton.setText("New Loan Analysis");
newLoanButton.setEnabled(false);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx =0;
gridConstraints.gridy = 5;
gridConstraints.gridwidth = 2;
gridConstraints.insets = new Insets(10, 0, 10, 5);
getContentPane().add(newLoanButton, gridConstraints);
newLoanButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
newLoanButtonActionPerformed(e);
}
});
monthsButton.setText("X");
monthsButton.setFocusable(false);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx =2;
gridConstraints.gridy = 2;
gridConstraints.insets = new Insets(10, 0, 5, 5);
getContentPane().add(monthsButton, gridConstraints);
monthsButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
monthsButtonActionPerformed(e);
}
});
paymentButton.setText("X");
paymentButton.setFocusable(false);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx =2;
gridConstraints.gridy = 3;
gridConstraints.insets = new Insets(10, 0, 5, 5);
getContentPane().add(paymentButton, gridConstraints);
paymentButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
paymentButtonActionPerformed(e);
}
});
analysisLabel.setText("Loan Analysis:");
analysisLabel.setFont(myFont);
gridConstraints = new GridBagConstraints(); gridConstraints.gridx =
3;
gridConstraints.gridy = 0;gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(0, 10, 5, 0);
getContentPane().add(analysisLabel, gridConstraints);
exitButton.setText("Exit");
exitButton.setFocusable(false);
gridConstraints = new GridBagConstraints(); gridConstraints.gridx =
3;
gridConstraints.gridy = 5;
getContentPane().add(exitButton, gridConstraints);
exitButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
exitButtonActionPerformed(e);
}
});
pack();
 
paymentButton.doClick();}
private void exitForm(WindowEvent evt)
{
System.exit(0);
}
private void computeButtonActionPerformed(ActionEvent e) {
double balance, interest, payment;
int months;
double monthlyInterest, multiplier;
double loanBalance, finalPayment;
if (validateDecimalNumber(balanceTextField)) {
balance = Double.valueOf(balanceTextField.getText()).doubleValue(); }
else
{
JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error",
JOptionPane.DEFAULT_OPTION,
JOptionPane.INFORMATION_MESSAGE); return;
}
if (validateDecimalNumber(interestTextField)) {
interest =
Double.valueOf(interestTextField.getText()).doubleValue(); }
else
{
JOptionPane.showConfirmDialog(null, "Invalid or empty InterestRate entry.\nPlease correct.", "Interest Input Error",
JOptionPane.DEFAULT_OPTION,
JOptionPane.INFORMATION_MESSAGE); return;
}
monthlyInterest = interest / 1200;
if (computePayment)
{

if (validateDecimalNumber(monthsTextField)) {
months =
Integer.valueOf(monthsTextField.getText()).intValue(); }
else
{
JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error",
JOptionPane.DEFAULT_OPTION,
JOptionPane.INFORMATION_MESSAGE); return;
}
if (interest == 0)
{
payment = balance / months;
}
else
{
multiplier = Math.pow(1 + monthlyInterest, months);
payment =balance * monthlyInterest * multiplier / (multiplier - 1); }
paymentTextField.setText(new
DecimalFormat("0.00").format(payment)); }
else
{

if (validateDecimalNumber(paymentTextField)) {
payment = Double.valueOf(paymentTextField.getText()).doubleValue();
if (payment <= (balance * monthlyInterest + 1.0)) {
if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" + new DecimalFormat("0.00").format((int)(balance *
monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
paymentTextField.setText(new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)));
payment =
Double.valueOf(paymentTextField.getText()).doubleValue(); }
else
{
paymentTextField.requestFocus();
return;
}
}
}
else
{JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error",
JOptionPane.DEFAULT_OPTION,
JOptionPane.INFORMATION_MESSAGE); return;
}
if (interest == 0)
{
months = (int)(balance / payment);
}
else
{
months = (int)((Math.log(payment) - Math.log(payment - balance
* monthlyInterest)) / Math.log(1 + monthlyInterest)); }
monthsTextField.setText(String.valueOf(months)); }
// reset payment prior to analysis to fix at two decimals 
payment = Double.valueOf(paymentTextField.getText()).doubleValue(); 
// show analysis
analysisTextArea.setText("If I borrow $" + new DecimalFormat("0.00").format(balance)); 
analysisTextArea.append("\n" +"At a " + new DecimalFormat("0.00").format(interest) + "% interest,"); 

loanBalance = balance;
for (int paymentNumber = 1; paymentNumber <= months - 1;
paymentNumber++) {
loanBalance += loanBalance * monthlyInterest - payment; }

finalPayment = loanBalance;
if (finalPayment > payment){
	
loanBalance += loanBalance * monthlyInterest - payment;
finalPayment = loanBalance;
months++;
monthsTextField.setText(String.valueOf(months)); }
analysisTextArea.append( "\n"+"I will pay $" + new DecimalFormat("0.00").format(payment)+" for "+String.valueOf(months/12)+" years("+months+" months)");
analysisTextArea.append("\n\n" + "Final Payment of: $" + new
DecimalFormat("0.00").format(finalPayment));
analysisTextArea.append("\n\n" + "Total Payments: $" + new
DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
analysisTextArea.append("\n\n" + "Interest Paid $" + new
DecimalFormat("0.00").format((months - 1) * payment + finalPayment -
balance)); computeButton.setEnabled(false);
newLoanButton.setEnabled(true);
newLoanButton.requestFocus();
}


private void newLoanButtonActionPerformed(ActionEvent e) {
// clear computed value and analysis
if (computePayment)
{
paymentTextField.setText("");


}
else
{
monthsTextField.setText("");
}
balanceTextField.setText("");
interestTextField.setText("");
monthsTextField.setText("");
analysisTextArea.setText("");
computeButton.setEnabled(true);
newLoanButton.setEnabled(false);
balanceTextField.requestFocus();
}


private void monthsButtonActionPerformed(ActionEvent e) {
// will compute months
computePayment = false;
paymentButton.setVisible(true);
monthsButton.setVisible(false);
monthsTextField.setText("");
monthsTextField.setEditable(false);
monthsTextField.setBackground(lightYellow);
monthsTextField.setFocusable(false);
paymentTextField.setEditable(true);
paymentTextField.setBackground(Color.WHITE);
paymentTextField.setFocusable(true);
computeButton.setText("Compute Number of Payments");
balanceTextField.requestFocus();
}


private void paymentButtonActionPerformed(ActionEvent e) {
// will compute payment
computePayment = true;
paymentButton.setVisible(false);
monthsButton.setVisible(true);
monthsTextField.setEditable(true);
monthsTextField.setBackground(Color.WHITE);
monthsTextField.setFocusable(true);
paymentTextField.setText("");
paymentTextField.setEditable(false);
paymentTextField.setBackground(lightYellow);paymentTextField.setFocusable(false);
computeButton.setText("Compute Monthly Payment");
balanceTextField.requestFocus();
}

private void exitButtonActionPerformed(ActionEvent e) {
System.exit(0);
}

private void balanceTextFieldActionPerformed(ActionEvent e) {
balanceTextField.transferFocus();
}

private void interestTextFieldActionPerformed(ActionEvent e) {
interestTextField.transferFocus();
}

private void monthsTextFieldActionPerformed(ActionEvent e) {
monthsTextField.transferFocus();
}

private void paymentTextFieldActionPerformed(ActionEvent e) {
paymentTextField.transferFocus();
}

private boolean validateDecimalNumber(JTextField tf) {
// checks to see if text field contains
// valid decimal number with only digits and a single decimal point
String s = tf.getText().trim();
boolean hasDecimal = false;
boolean valid = true;if (s.length() == 0)
{
valid = false;
}
else
{
for (int i = 0; i < s.length(); i++)
{
char c = s.charAt(i);
if (c >= '0' && c <= '9')
{
continue;
}
else if (c == '.' && !hasDecimal)
{
hasDecimal = true;
}
else
{
// invalid character found
valid = false;
}}
}
tf.setText(s);
if (!valid)
{
tf.requestFocus();
}
return (valid);
}
}
