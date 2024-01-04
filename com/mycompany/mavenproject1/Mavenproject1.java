/*     */ package com.mycompany.mavenproject1;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Mavenproject1
/*     */ {
/*  34 */   static JLabel textLabel = new JLabel("Ready");
/*     */   
/*  36 */   static List allTextFiles = new ArrayList();
/*  37 */   static Mavenproject1 folderCrawler = new Mavenproject1();
/*     */   static GraphicsConfiguration gc;
/*     */   
/*     */   public static void main(String[] args) {
/*  41 */     textLabel.setPreferredSize(new Dimension(450, 24));
/*  42 */     String home = System.getProperty("user.home");
/*  43 */     home = String.valueOf(home) + "\\Music";
/*     */     
/*  45 */     JFrame frame = new JFrame(gc);
/*     */ 
/*     */     
/*  48 */     JButton button = new JButton("clean");
/*  49 */     JButton button1 = new JButton("exit");
/*     */     
/*  51 */     final JTextField textField1 = new JTextField("o_");
/*  52 */     frame.add(textField1);
/*  53 */     textField1.setPreferredSize(new Dimension(75, 24));
/*  54 */     final JSpinner spinner = new JSpinner();
/*     */ 
/*     */     
/*  57 */     final JTextField textField = new JTextField(home);
/*  58 */     frame.add(textField);
/*  59 */     textField.setPreferredSize(new Dimension(250, 24));
/*  60 */     frame.add(spinner);
/*  61 */     frame.add(button);
/*  62 */     frame.add(button1);
/*     */     
/*  64 */     frame.setLayout(new FlowLayout());
/*  65 */     frame.setTitle("cleaner for nerds");
/*     */     
/*  67 */     frame.add(textLabel);
/*     */     
/*  69 */     frame.setSize(600, 100);
/*  70 */     frame.setVisible(true);
/*  71 */     frame.setResizable(false);
/*     */     
/*  73 */     button1.addActionListener(e -> System.exit(0));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     button.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/*  81 */             Mavenproject1.textLabel.setText("Working");
/*  82 */             Mavenproject1.textLabel.paintImmediately(Mavenproject1.textLabel.getVisibleRect());
/*  83 */             System.out.println("START");
/*  84 */             int value = ((Integer)spinner.getValue()).intValue();
/*  85 */             Mavenproject1.startCrawling(textField.getText(), textField1.getText(), value);
/*  86 */             System.out.println("DONE");
/*  87 */             Mavenproject1.textLabel.setText("Ready");
/*  88 */             Mavenproject1.textLabel.paintImmediately(Mavenproject1.textLabel.getVisibleRect());
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void startCrawling(String path, String prefix, int offset) {
/*  98 */     crawlFold(path, prefix, offset);
/*  99 */     for (Object object : allTextFiles);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void crawlFold(String path, String prefix, int offset) {
/* 109 */     File folder = new File(path);
/* 110 */     System.out.println(folder);
/* 111 */     File[] listOfFiles = folder.listFiles();
/*     */     
/* 113 */     for (int i = 0; i < listOfFiles.length; i++) {
/* 114 */       if (listOfFiles[i].isFile()) {
/* 115 */         if (listOfFiles[i].getName().startsWith(prefix))
/*     */         {
/*     */           
/* 118 */           String newFileName = listOfFiles[i].getName().substring(prefix.length() + offset);
/*     */           
/* 120 */           for (int j = 0; j < listOfFiles.length; j++) {
/* 121 */             if (listOfFiles[j].getName().equals(newFileName)) {
/* 122 */               System.out.println("deleting " + newFileName);
/* 123 */               listOfFiles[j].delete();
/*     */             } 
/*     */           } 
/*     */           
/* 127 */           String currentPath = listOfFiles[i].getParent();
/* 128 */           File newfile = new File(String.valueOf(currentPath) + "\\" + newFileName);
/*     */           
/* 130 */           System.out.println("renaming " + listOfFiles[i].getName() + " to " + newfile.getName());
/*     */ 
/*     */           
/* 133 */           listOfFiles[i].renameTo(newfile);
/*     */ 
/*     */           
/* 136 */           textLabel.setText(newfile.getName());
/* 137 */           textLabel.paintImmediately(textLabel.getVisibleRect());
/*     */           
/* 139 */           allTextFiles.add(listOfFiles[i].getName());
/*     */         }
/*     */       
/* 142 */       } else if (listOfFiles[i].isDirectory()) {
/*     */         
/* 144 */         crawlFold(String.valueOf(path) + File.separator + listOfFiles[i].getName(), prefix, offset);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\downloads\cleaner4nerds.jar!\com\mycompany\mavenproject1\Mavenproject1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */