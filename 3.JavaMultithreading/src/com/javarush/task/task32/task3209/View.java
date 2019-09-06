package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.basic");
        }catch (Exception e){
            ExceptionHandler.log(e);
        }

    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(),"java rush","title",JOptionPane.INFORMATION_MESSAGE);
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public void undo(){
        try {
            undoManager.undo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try {
            undoManager.redo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void init(){
        initGui();
        addWindowListener(new FrameListener(this));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,menuBar);
        MenuHelper.initEditMenu(this,menuBar);
        MenuHelper.initStyleMenu(this,menuBar);
        MenuHelper.initAlignMenu(this,menuBar);
        MenuHelper.initColorMenu(this,menuBar);
        MenuHelper.initFontMenu(this,menuBar);
        MenuHelper.initHelpMenu(this,menuBar);
        getContentPane().add(menuBar,BorderLayout.NORTH);
    }


    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollPanehtml = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML",scrollPanehtml);
        JScrollPane scrollPanetxt = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст",scrollPanetxt);
        tabbedPane.setPreferredSize(new Dimension(700,700));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public void initGui(){
        initEditor();
        initMenuBar();
        pack();
    }

    public void exit(){
        controller.exit();
    }


    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str){
            case "Новый" : controller.createNewDocument();
                break;
            case "Открыть" : controller.openDocument();
                break;
            case  "Сохранить" : controller.saveDocument();
                break;
            case "Сохранить как..." : controller.saveDocumentAs();
                break;
            case "Выход" : controller.exit();
                break;
            case "О программе" : showAbout();
                break;
        }
    }

    public void selectedTabChanged(){
        if(tabbedPane.getSelectedIndex() == 0){
            controller.setPlainText(plainTextPane.getText());
        }else if(tabbedPane.getSelectedIndex() == 1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }
}
