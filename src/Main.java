package cryptoRunner;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main
{
    public static String version;
    
    static {
        Main.version = "3BX";
    }
    
    public static void main(final String[] args) {
        runGUI();
    }
    
    public static void restartGUI(final JFrame frame) {
        frame.dispose();
        runGUI();
    }
    
    public static void runGUI() {
        final JFrame frame = new JFrame("CryptoHasher 3.0");
        frame.setDefaultCloseOperation(3);
        frame.setSize(330, 180);
        frame.setVisible(true);
        final JPanel panel = new JPanel();
        frame.add(panel);
        final JButton create = new JButton("Create A Basic Crypto Hash");
        final JButton sign = new JButton("Sign Code");
        final JButton verify = new JButton("Verify A Crypto Hash");
        final JButton verifyCode = new JButton("Verify Signed Code");
        final JButton quit = new JButton("Quit");
        sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                frame.dispose();
                final JFrame frame2 = new JFrame("Create Hash");
                frame2.setVisible(true);
                frame2.setSize(900, 800);
                final JPanel nested1 = new JPanel();
                final JTextField text1 = new JTextField(16);
                final JLabel label1 = new JLabel("Enter Client Password:");
                nested1.add(label1);
                nested1.add(text1);
                final JPanel nested2 = new JPanel();
                final JTextField text2 = new JTextField("0", 16);
                final JLabel label2 = new JLabel("Enter Negotiation Number:");
                final JTextArea text3 = new JTextArea();
                text3.setColumns(70);
                text3.setRows(40);
                final JLabel label3 = new JLabel("Enter Code Below:");
                nested2.add(label2);
                nested2.add(text2);
                nested2.add(label3);
                nested2.add(text3);
                final JScrollPane scroll = new JScrollPane(text3, 22, 32);
                nested2.add(scroll);
                final JPanel nested3 = new JPanel();
                final JButton submit = new JButton("Calculate Hash");
                nested3.add(submit);
                frame2.add(nested1, "First");
                frame2.add(nested2, "Center");
                frame2.add(nested3, "Last");
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        frame2.dispose();
                        final JFrame frame3 = new JFrame("Hash Generator");
                        frame3.setVisible(true);
                        frame3.setSize(500, 130);
                        final JPanel nested1 = new JPanel();
                        final JLabel label1 = new JLabel("Generated Hash:");
                        final JPanel nested2 = new JPanel();
                        final JPanel nested3 = new JPanel();
                        final JButton exit = new JButton("Restart");
                        exit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(final ActionEvent e) {
                                Main.restartGUI(frame3);
                            }
                        });
                        final JTextField finalText = new JTextField(CryptoEncoder.ComplexHash(text2.getText(), text3.getText(), text1.getText()));
                        nested1.add(label1);
                        nested2.add(finalText);
                        nested2.add(finalText);
                        nested3.add(exit);
                        frame3.add(nested1, "North");
                        frame3.add(nested2, "Center");
                        frame3.add(nested3, "South");
                    }
                });
            }
        });
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                frame.dispose();
                final JFrame frame2 = new JFrame("Create Hash");
                frame2.setVisible(true);
                frame2.setSize(900, 160);
                final JPanel nested1 = new JPanel();
                final JTextField text1 = new JTextField(16);
                final JLabel label1 = new JLabel("Enter Client Password:");
                nested1.add(label1);
                nested1.add(text1);
                final JPanel nested2 = new JPanel();
                final JTextField text2 = new JTextField("0", 16);
                final JLabel label2 = new JLabel("Enter Negotiation Number:");
                final JTextField text3 = new JTextField(16);
                final JLabel label3 = new JLabel("Enter Salt (Optional):");
                nested2.add(label2);
                nested2.add(text2);
                nested2.add(label3);
                nested2.add(text3);
                final JPanel nested3 = new JPanel();
                final JButton submit = new JButton("Calculate Hash");
                nested3.add(submit);
                frame2.add(nested1, "First");
                frame2.add(nested2, "Center");
                frame2.add(nested3, "Last");
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        frame2.dispose();
                        final JFrame frame3 = new JFrame("Hash Generator");
                        frame3.setVisible(true);
                        frame3.setSize(500, 130);
                        final JPanel nested1 = new JPanel();
                        final JLabel label1 = new JLabel("Generated Hash:");
                        final JPanel nested2 = new JPanel();
                        final JPanel nested3 = new JPanel();
                        final JButton exit = new JButton("Restart");
                        exit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(final ActionEvent e) {
                                Main.restartGUI(frame3);
                            }
                        });
                        final JTextField finalText = new JTextField(CryptoEncoder.ComplexHash(text2.getText(), text3.getText(), text1.getText()));
                        nested1.add(label1);
                        nested2.add(finalText);
                        nested2.add(finalText);
                        nested3.add(exit);
                        frame3.add(nested1, "North");
                        frame3.add(nested2, "Center");
                        frame3.add(nested3, "South");
                    }
                });
            }
        });
        verify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                frame.dispose();
                final JFrame frame2 = new JFrame("Verify Hash");
                frame2.setVisible(true);
                frame2.setSize(1000, 160);
                final JPanel nested1 = new JPanel();
                final JTextField text1 = new JTextField(16);
                final JLabel label1 = new JLabel("Enter Client Password:");
                nested1.add(label1);
                nested1.add(text1);
                final JPanel nested2 = new JPanel();
                final JTextField text2 = new JTextField("0", 16);
                final JLabel label2 = new JLabel("Enter Negotiation Number:");
                nested2.add(label2);
                nested2.add(text2);
                final JTextField text3 = new JTextField(16);
                final JLabel label3 = new JLabel("Enter Hash:");
                final JTextField text4 = new JTextField(16);
                final JLabel label4 = new JLabel("Enter Salt (Optional):");
                nested2.add(label3);
                nested2.add(text3);
                nested2.add(label4);
                nested2.add(text4);
                final JPanel nested3 = new JPanel();
                final JButton submit = new JButton("Verify Hash");
                nested3.add(submit);
                frame2.add(nested1, "First");
                frame2.add(nested2, "Center");
                frame2.add(nested3, "Last");
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        frame2.dispose();
                        final JFrame frame3 = new JFrame("Verify Hash");
                        frame3.setVisible(true);
                        frame3.setSize(550, 140);
                        final JPanel nested1 = new JPanel();
                        final JPanel nested2 = new JPanel();
                        final JPanel nested3 = new JPanel();
                        if (CryptoEncoder.VerifyComplexHash(text2.getText(), text1.getText(), text4.getText(), text3.getText()) && text3.getText().contains(Main.version)) {
                            final JLabel label1 = new JLabel("Hash Verification Successful!");
                            final JLabel label2 = new JLabel("User Input: " + text3.getText());
                            final JLabel label3 = new JLabel("Expected Result: " + CryptoEncoder.ComplexHash(text2.getText(), text4.getText(), text1.getText()));
                            final JButton exit = new JButton("Restart");
                            exit.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(final ActionEvent e) {
                                    Main.restartGUI(frame3);
                                }
                            });
                            nested1.add(label1);
                            nested2.add(label2);
                            nested3.add(label3);
                            nested1.add(exit);
                            frame3.add(nested1, "First");
                            frame3.add(nested2, "Center");
                            frame3.add(nested3, "Last");
                        }
                        else if (text3.getText().contains(Main.version)) {
                            final JLabel label1 = new JLabel("HASH VERIFICATION FAILED!!!");
                            final JLabel label2 = new JLabel("User Input: " + text3.getText());
                            final JLabel label3 = new JLabel("Expected Result: " + CryptoEncoder.ComplexHash(text2.getText(), text4.getText(), text1.getText()));
                            final JButton exit = new JButton("Restart");
                            exit.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(final ActionEvent e) {
                                    Main.restartGUI(frame3);
                                }
                            });
                            nested1.add(label1);
                            nested2.add(label2);
                            nested3.add(label3);
                            nested1.add(exit);
                            frame3.add(nested1, "First");
                            frame3.add(nested2, "Center");
                            frame3.add(nested3, "Last");
                        }
                        else {
                            final JLabel label1 = new JLabel("HASH VERIFICATION FAILED!!!");
                            final JLabel label2 = new JLabel("Hash entered was created in a different version of this program");
                            final JLabel label3 = new JLabel("Both users should update and try again");
                            final JButton exit = new JButton("Restart");
                            exit.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(final ActionEvent e) {
                                    Main.restartGUI(frame3);
                                }
                            });
                            nested1.add(label1);
                            nested2.add(label2);
                            nested3.add(label3);
                            nested1.add(exit);
                            frame3.add(nested1, "First");
                            frame3.add(nested2, "Center");
                            frame3.add(nested3, "Last");
                        }
                    }
                });
            }
        });
        verifyCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                frame.dispose();
                final JFrame frame2 = new JFrame("Verify Hash");
                frame2.setVisible(true);
                frame2.setSize(1000, 800);
                final JPanel nested1 = new JPanel();
                final JTextField text1 = new JTextField(16);
                final JLabel label1 = new JLabel("Enter Client Password:");
                nested1.add(label1);
                nested1.add(text1);
                final JPanel nested2 = new JPanel();
                final JTextField text2 = new JTextField("0", 16);
                final JLabel label2 = new JLabel("Enter Negotiation Number:");
                nested2.add(label2);
                nested2.add(text2);
                final JTextField text3 = new JTextField(16);
                final JLabel label3 = new JLabel("Enter Hash:");
                final JLabel label4 = new JLabel("Paste Code:");
                final JTextArea text4 = new JTextArea();
                text4.setColumns(70);
                text4.setRows(40);
                nested2.add(label3);
                nested2.add(text3);
                nested2.add(label4);
                nested2.add(text4);
                final JScrollPane scroll = new JScrollPane(text4, 22, 32);
                nested2.add(scroll);
                final JPanel nested3 = new JPanel();
                final JButton submit = new JButton("Verify Hash");
                nested3.add(submit);
                frame2.add(nested1, "First");
                frame2.add(nested2, "Center");
                frame2.add(nested3, "Last");
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        frame2.dispose();
                        final JFrame frame3 = new JFrame("Verify Hash");
                        frame3.setVisible(true);
                        frame3.setSize(550, 140);
                        final JPanel nested1 = new JPanel();
                        final JPanel nested2 = new JPanel();
                        final JPanel nested3 = new JPanel();
                        if (CryptoEncoder.VerifyComplexHash(text2.getText(), text1.getText(), text4.getText(), text3.getText()) && text3.getText().contains(Main.version)) {
                            final JLabel label1 = new JLabel("Hash Verification Successful!");
                            final JLabel label2 = new JLabel("User Input: " + text3.getText());
                            final JLabel label3 = new JLabel("Expected Result: " + CryptoEncoder.ComplexHash(text2.getText(), text4.getText(), text1.getText()));
                            final JButton exit = new JButton("Restart");
                            exit.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(final ActionEvent e) {
                                    Main.restartGUI(frame3);
                                }
                            });
                            nested1.add(label1);
                            nested2.add(label2);
                            nested3.add(label3);
                            nested1.add(exit);
                            frame3.add(nested1, "First");
                            frame3.add(nested2, "Center");
                            frame3.add(nested3, "Last");
                        }
                        else if (text3.getText().contains(Main.version)) {
                            final JLabel label1 = new JLabel("HASH VERIFICATION FAILED!!!");
                            final JLabel label2 = new JLabel("User Input: " + text3.getText());
                            final JLabel label3 = new JLabel("Expected Result: " + CryptoEncoder.ComplexHash(text2.getText(), text4.getText(), text1.getText()));
                            final JButton exit = new JButton("Restart");
                            exit.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(final ActionEvent e) {
                                    Main.restartGUI(frame3);
                                }
                            });
                            nested1.add(label1);
                            nested2.add(label2);
                            nested3.add(label3);
                            nested1.add(exit);
                            frame3.add(nested1, "First");
                            frame3.add(nested2, "Center");
                            frame3.add(nested3, "Last");
                        }
                        else {
                            final JLabel label1 = new JLabel("HASH VERIFICATION FAILED!!!");
                            final JLabel label2 = new JLabel("Hash entered was created in a different version of this program");
                            final JLabel label3 = new JLabel("Both users should update and try again");
                            final JButton exit = new JButton("Restart");
                            exit.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(final ActionEvent e) {
                                    Main.restartGUI(frame3);
                                }
                            });
                            nested1.add(label1);
                            nested2.add(label2);
                            nested3.add(label3);
                            nested1.add(exit);
                            frame3.add(nested1, "First");
                            frame3.add(nested2, "Center");
                            frame3.add(nested3, "Last");
                        }
                    }
                });
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(create);
        panel.add(verify);
        panel.add(sign);
        panel.add(verifyCode);
    }
}
