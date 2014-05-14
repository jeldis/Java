/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multi.threading;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class SwingWorkerExample extends JFrame {

    private JLabel countLabel1 = new JLabel("0");
    private JLabel statusLabel = new JLabel("Task not completed.");
    private JButton startButton = new JButton("Start");

    public SwingWorkerExample(String title) {
        super(title);

        setLayout(new GridBagLayout());

        countLabel1.setFont(new Font("serif", Font.BOLD, 28));

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(countLabel1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        add(statusLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        add(startButton, gc);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                start();
            }
        });

        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Bad practice
    private void start01() {
        Thread worker;
        worker = new Thread() {
            @Override
            public void run() {

                // Simulate doing something useful.
                for (int i = 0; i <= 10; i++) {
                    // Bad practice
                    countLabel1.setText(Integer.toString(i));

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }

                // Bad practice
                statusLabel.setText("Completed.");
            }
        };

        worker.start();
    }

    //The following code is fine, but ugly as the devil himself.
    private void start02() {
        Thread worker = new Thread() {
            @Override
            public void run() {

                // Simulate doing something useful.
                for (int i = 0; i <= 10; i++) {

                    final int count = i;

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            countLabel1.setText(Integer.toString(count));
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        statusLabel.setText("Completed.");
                    }
                });

            }
        };

        worker.start();
    }
    //============================================================
    //Running a Background Task
    //

    private void start03() {

        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // Simulate doing something useful.
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(1000);
                    System.out.println("Running " + i);
                }

                // Here we can return some object of whatever type
                // we specified for the first template parameter.
                // (in this case we're auto-boxing 'true').
                return true;
            }

            // Can safely update the GUI from this method.
            @Override
            protected void done() {

                boolean status;
                try {
                    // Retrieve the return value of doInBackground.
                    status = get();
                    statusLabel.setText("Completed with status: " + status);
                } catch (InterruptedException e) {
                    // This is thrown if the thread's interrupted.
                } catch (ExecutionException e) {
                    // This is thrown if we throw an exception
                    // from doInBackground.
                }
            }
        };

        worker.execute();

    }

    //=====================================================================
    private void start() {
        SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                // Simulate doing something useful.
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(1000);
                    System.out.println("Running " + i);
                    // The type we pass to publish() is determined
                    // by the second template parameter.
                    publish(i);
                }

                // Here we can return some object of whatever type
                // we specified for the first template parameter.
                // (in this case we're auto-boxing 'true').
                return true;
            }

            // Can safely update the GUI from this method.
            @Override
            protected void done() {

                boolean status;
                try {
                    // Retrieve the return value of doInBackground.
                    status = get();
                    statusLabel.setText("Completed with status: " + status);
                } catch (InterruptedException e) {
                    // This is thrown if the thread's interrupted.
                } catch (ExecutionException e) {
                    // This is thrown if we throw an exception
                    // from doInBackground.
                }
            }

            @Override
            protected void process(List<Integer> chunks) {
                // Here we receive the values that we publish().
                // They may come grouped in chunks.
                int mostRecentValue = chunks.get(chunks.size() - 1);

                countLabel1.setText(Integer.toString(mostRecentValue));
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {

        //http://www.javacodegeeks.com/2012/12/multi-threading-in-java-swing-with-swingworker.html
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingWorkerExample("SwingWorker Demo");
            }
        });
    }
}