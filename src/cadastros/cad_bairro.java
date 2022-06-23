/*
 * Copyright (C) 2022 Adriano Silva
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cadastros;

/**
 *
 * @author Adriano Silva
 */
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.conexao;

/**
 *
 * @author Adriano Silva
 */
public class cad_bairro extends javax.swing.JFrame {
    
    int navega = 0;
    int inicia_combo =0;
    String ordenacao="nome";
    conexao con_bairro;
    /**
     * Creates new form cad_cidade
     */
    public cad_bairro() {
        initComponents();
        con_bairro = new conexao();
        con_bairro.conecta();
        con_bairro.executeSQL("select * from bairro order by "+ordenacao);
       
        try
        {
          atualiza_combo_box_bairro(); 
          con_bairro.resultset.first();
          mostrar_dados();
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não localizou dados "+erro);
        }     
        preencher_jtable();//chama metodp para preencher o JTable  
   }
    
        
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_ordenacao = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();
        tf_nome = new javax.swing.JTextField();
        botao_primeiro = new javax.swing.JButton();
        botao_anterior = new javax.swing.JButton();
        botao_proximo = new javax.swing.JButton();
        botao_ultimo = new javax.swing.JButton();
        botão_gravar = new javax.swing.JButton();
        botao_inserir = new javax.swing.JButton();
        botao_excluir = new javax.swing.JButton();
        botao_alterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tf_pesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcb_pesquisa = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rb_codigo = new javax.swing.JRadioButton();
        rb_nome = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setTitle("Cadastro de Bairro");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadastro_bairro.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Código.:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Bairro.:");

        botao_primeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Rewind.png"))); // NOI18N
        botao_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_primeiroActionPerformed(evt);
            }
        });

        botao_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Playback.png"))); // NOI18N
        botao_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_anteriorActionPerformed(evt);
            }
        });

        botao_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Play.png"))); // NOI18N
        botao_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_proximoActionPerformed(evt);
            }
        });

        botao_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fast-forward.png"))); // NOI18N
        botao_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ultimoActionPerformed(evt);
            }
        });

        botão_gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Save.png"))); // NOI18N
        botão_gravar.setText("   Gravar");
        botão_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botão_gravarActionPerformed(evt);
            }
        });

        botao_inserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        botao_inserir.setText("   Novo");
        botao_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_inserirActionPerformed(evt);
            }
        });

        botao_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Erase.png"))); // NOI18N
        botao_excluir.setText("   Excluir");
        botao_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirActionPerformed(evt);
            }
        });

        botao_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Modify.png"))); // NOI18N
        botao_alterar.setText("   Alterar");
        botao_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alterarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nome do Bairro"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tf_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pesquisaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Pesquisar.:");

        jcb_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_pesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jcb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ordenação");

        grupo_ordenacao.add(rb_codigo);
        rb_codigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_codigo.setText("Código");
        rb_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_codigoActionPerformed(evt);
            }
        });

        grupo_ordenacao.add(rb_nome);
        rb_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_nome.setSelected(true);
        rb_nome.setText("Nome");
        rb_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_nomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_nome)
                    .addComponent(jLabel3)
                    .addComponent(rb_codigo))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_codigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_nome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/View.png"))); // NOI18N
        jButton1.setText("   Filtrar na Grade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botao_primeiro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_anterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_proximo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_ultimo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botao_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_inserir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botao_excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botão_gravar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botao_primeiro)
                        .addComponent(botao_anterior, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botao_proximo)
                        .addComponent(botao_ultimo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botão_gravar)
                        .addComponent(botao_inserir)
                        .addComponent(botao_excluir)
                        .addComponent(botao_alterar)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(778, 633));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_proximoActionPerformed
 try
        {
           con_bairro.resultset.next();
        
           mostrar_dados();
           navega = 2;
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possível ir para o próximo registro "+erro);
        }          
    }//GEN-LAST:event_botao_proximoActionPerformed

    private void botão_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botão_gravarActionPerformed
        // TODO add your handling code here:
        try
        {
            //insert int cidade (nome,uf) values ('Carazinho','RS')

            String sqlinsert ="insert into bairro (nome) values ('"+
                         tf_nome.getText()+"')";
                         con_bairro.statement.executeUpdate(sqlinsert);         
            JOptionPane.showMessageDialog(null,"Gravação realizado com sucesso!");

           //atualiza o ResultSet
           //con_cidade.resultset = con_cidade.statement.executeQuery("Select * from cidade");
           con_bairro.executeSQL("select * from bairro order by "+ordenacao);
           atualiza_combo_box_bairro();
           con_bairro.resultset.first(); //posiciona no primeiro registro
           mostrar_dados(); //irá chamar a função em que irá mstrar os dados no form
        }
        catch (SQLException erro)
     {
	JOptionPane.showMessageDialog(null,"Erro a tentar Gravar o registro..."+erro);
     }
        
    }//GEN-LAST:event_botão_gravarActionPerformed

    private void botao_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_primeiroActionPerformed
         try
        {
           con_bairro.resultset.first();
        
           mostrar_dados();
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possível ir para o primeiro registro "+erro);
        }  
    }//GEN-LAST:event_botao_primeiroActionPerformed

    private void botao_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ultimoActionPerformed
         try
        {
           con_bairro.resultset.last();
        
          mostrar_dados();
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possível ir para o último registro "+erro);
        }  
    }//GEN-LAST:event_botao_ultimoActionPerformed

    private void botao_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_anteriorActionPerformed
         try
        {
           con_bairro.resultset.previous();
        
           mostrar_dados();
           navega = 1;
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possível ir para o registro anterior "+erro);
        }  
    }//GEN-LAST:event_botao_anteriorActionPerformed

    private void botao_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_inserirActionPerformed
        tf_codigo.setText("");
        tf_nome.setText("");
        //cb_cidade.setSelectedItem("Distrito Federal");
        tf_nome.requestFocus();
        tf_codigo.setEditable(false); 
    }//GEN-LAST:event_botao_inserirActionPerformed

    private void botao_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirActionPerformed
        try
    {
        
      	String sql = "select * from bairro Where codigo = "+tf_codigo.getText();
   	con_bairro.executeSQL(sql); 
        con_bairro.resultset.first();
        String nome = "Deletar o Endereço : "+con_bairro.resultset.getString("nome")+" ?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"Exclusão ",JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION)
   	{
   	    sql = "DELETE FROM bairro Where codigo ="+tf_codigo.getText();
  	    int conseguiu_excluir = con_bairro.statement.executeUpdate(sql);
  	    if (conseguiu_excluir == 1)
            {
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                //atualiza o ResultSet
                con_bairro.executeSQL("select * from bairro order by "+ordenacao);
                atualiza_combo_box_bairro();
                //atualiza_cb_cidade();
                con_bairro.resultset.first(); //posiciona no primeiro registro
                mostrar_dados(); //irá chamar a função em que irá mstrar os dados no form
            }
         } 	
         else 
           return;  
    } 
    catch (SQLException erro)
    {
	JOptionPane.showMessageDialog(null,"Erro a tentar excluir o registro..."+erro);
     }  
    }//GEN-LAST:event_botao_excluirActionPerformed

    private void botao_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alterarActionPerformed
        try
    {
        String sql ="UPDATE bairro SET nome ='"+tf_nome.getText()+"' where codigo = "+tf_codigo.getText();
        con_bairro.statement.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Alteração realizado com sucesso!");
       
       //atualiza o ResultSet
       con_bairro.executeSQL("select * from bairro order by "+ordenacao);
       atualiza_combo_box_bairro();
       con_bairro.resultset.next(); //posiciona no primeiro registro
       mostrar_dados(); //irá chamar a função em que irá mstrar os dados no form
     }
     catch (SQLException erro)
     {
	JOptionPane.showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
     }
    }//GEN-LAST:event_botao_alterarActionPerformed

    private void jcb_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_pesquisaActionPerformed
      if (inicia_combo == 1)
    {    
        try
         {
                con_bairro.resultset.first();
                String igual = "n"; //inicia dizendo que não localizou a cidade                  
                while(igual == "n") //diz que enquanto não localizar é para ir executando
                {
                        if (con_bairro.resultset.getString("nome").equals(jcb_pesquisa.getSelectedItem()))
                        {
                            igual = "s"; //indica que achou a cidade
                        }
                        else
                            con_bairro.resultset.next(); //enquanto não achar vai para o proximo                   
                    }
                   // nas linhas abaxo, mostra_conteudo_tabela();
                  tf_codigo.setText(con_bairro.resultset.getString("codigo"));//Essas duas linhas são necesárias                   
                   mostrar_dados();
               }
        catch(Exception erro)
        {
            //JOptionPane.showMessageDialog(null, "Não conseguiu localizar via Seleção no JComboBox, erro = "+erro);
        }
    }
    inicia_combo=1;
    }//GEN-LAST:event_jcb_pesquisaActionPerformed

    private void tf_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pesquisaActionPerformed
        try
        {
               con_bairro.resultset.first();
               String igual = "n";
               int tamanho_pesquisa = tf_pesquisa.getText().length();
               while(igual == "n")
               {
                     String pesquisado = con_bairro.resultset.getString("nome").substring(0,(tamanho_pesquisa));

                        if (pesquisado.equals(tf_pesquisa.getText()))
                        {
                             igual = "s";
                        }
                    else
                         con_bairro.resultset.next();
                }                          
               // nas linhas abaxo, mostra_conteudo_tabela();
               tf_codigo.setText(con_bairro.resultset.getString("codigo"));//Essas duas linhas é necesária                   
               mostrar_dados();                              
               jcb_pesquisa.setSelectedItem(tf_nome.getText());
        }
        catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null, "Não conseguiu localizar via digitação, erro = "+erro);
        }
    }//GEN-LAST:event_tf_pesquisaActionPerformed

    private void rb_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_codigoActionPerformed
        ordem_visualizacao("codigo");
    }//GEN-LAST:event_rb_codigoActionPerformed

    private void rb_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_nomeActionPerformed
        ordem_visualizacao("nome");
    }//GEN-LAST:event_rb_nomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        con_bairro.executeSQL("select * from bairro where nome like '"+tf_pesquisa.getText()+"%' order by "+ordenacao);          
          preencher_jtable();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(cad_cidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cad_cidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cad_cidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cad_cidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cad_bairro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_alterar;
    private javax.swing.JButton botao_anterior;
    private javax.swing.JButton botao_excluir;
    private javax.swing.JButton botao_inserir;
    private javax.swing.JButton botao_primeiro;
    private javax.swing.JButton botao_proximo;
    private javax.swing.JButton botao_ultimo;
    private javax.swing.JButton botão_gravar;
    private javax.swing.ButtonGroup grupo_ordenacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox jcb_pesquisa;
    private javax.swing.JRadioButton rb_codigo;
    private javax.swing.JRadioButton rb_nome;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_pesquisa;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void mostrar_dados()
    {
         try
        {
           //con_bairro.resultset.first();
        
           tf_codigo.setText(con_bairro.resultset.getString("codigo"));
           tf_nome.setText(con_bairro.resultset.getString("nome"));
           //cb_cidade.setSelectedItem(con_bairro.resultset.getString("uf"));
        }
        catch(SQLException erro)
        {
            if (navega == 1)
                JOptionPane.showMessageDialog(null,"Você já está no primeiro registro");
            else if (navega == 2)
                 JOptionPane.showMessageDialog(null,"Você já está no último registro");
            else
            JOptionPane.showMessageDialog(null,"Não localizou dados "+erro);
        }  
    }

    /**
     *
     */
    public void atualiza_combo_box_bairro()
    {
        try
        {
          jcb_pesquisa.removeAllItems();
          con_bairro.executeSQL("select * from bairro order by "+ordenacao);
          while(con_bairro.resultset.next())
              jcb_pesquisa.addItem(con_bairro.resultset.getString("nome"));           
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não localizou dados "+erro);
        }

    }

    /**
     *
     */
    public void preencher_jtable()
    {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        
         
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
         
        try
        {
            
           while (con_bairro.resultset.next()) 
                 modelo.addRow(new Object [] {con_bairro.resultset.getString("codigo"),con_bairro.resultset.getString("nome")});
           con_bairro.resultset.first();
         }  
         catch (SQLException erro){
             JOptionPane.showMessageDialog(null,"Erro ao listar no JTable "+erro);
        }
    }

    /**
     *
     * @param Ordem
     */
    public void ordem_visualizacao(String Ordem)
    {
        ordenacao = Ordem;
        con_bairro.executeSQL("select * from bairro  order by "+ordenacao);           
        preencher_jtable();
        atualiza_combo_box_bairro();
        try
        {
            con_bairro.resultset.first();
        }
         catch (SQLException erro){
             JOptionPane.showMessageDialog(null,"Erro na ordenação dos dados "+erro);
        }
        mostrar_dados();
        
    }
}