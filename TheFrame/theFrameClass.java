package TheFrame;

import Compression_Decompression.Compression;
import Compression_Decompression.Decompression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class theFrameClass extends JFrame implements ActionListener
{
    //static JFrame window;
    JButton comp,decomp;
    JLabel staticText;
    JPanel panel,buttonPanel;
    public theFrameClass()
    {
        Color c1 = new Color(26 ,188,156);
        Color buttonbg = new Color(18,71,95);
        //window = new JFrame("TheGUI");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(700,600);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(c1);

        staticText = new JLabel("Compress or Decompress files");
        staticText.setHorizontalAlignment(SwingConstants.CENTER);
        staticText.setFont(staticText.getFont().deriveFont(Font.BOLD, staticText.getFont().getSize() + 30f));
        panel.add(staticText, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(c1);

        comp = new JButton("Select file to compress");
        comp.setBackground(buttonbg);
        comp.setForeground(Color.WHITE);
        comp.setPreferredSize(new Dimension(300, 40));

        decomp = new JButton("Select file to decompress");
        decomp.setBackground(buttonbg);
        decomp.setForeground(Color.WHITE);
        decomp.setPreferredSize(new Dimension(300, 40));

        buttonPanel.add(comp);
        buttonPanel.add(Box.createHorizontalStrut(30));
        buttonPanel.add(decomp);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(250, 0, 0, 0));
        panel.add(buttonPanel, BorderLayout.CENTER);

        super.add(panel);
        super.setVisible(true);
        decomp.addActionListener(this);
        comp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == comp)
        {
            JFileChooser fc = new JFileChooser();
            int res = fc.showSaveDialog(null);
            if(res == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fc.getSelectedFile().getAbsolutePath());
                try
                {
                    Compression.comp_method(file);
                    JOptionPane.showMessageDialog(null,"Your file is compressed and saved");
                }
                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(null,e1.toString());
                }
            }
        }
        else if (e.getSource() == decomp)
        {
            JFileChooser fc = new JFileChooser();
            int res = fc.showSaveDialog(null);
            if(res == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fc.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try
                {
                    Decompression.decomp_method(file);
                    JOptionPane.showMessageDialog(null,"Your file is Decompressed and saved");
                }
                catch (Exception e2)
                {
                    JOptionPane.showMessageDialog(null,e2.toString());
                }
            }
        }

    }
}
