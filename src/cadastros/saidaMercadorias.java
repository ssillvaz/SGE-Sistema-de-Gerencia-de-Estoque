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


/**
 *
 * @author Adriano Silva
 */
package cadastros;

import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import utilitarios.conexao;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Adriano Silva
 */
public final class saidaMercadorias extends javax.swing.JFrame {
    
    MaskFormatter formatoData;
    int navega = 0;
    int inicia_combo =0;
    String ordenacao="nome";
    boolean primeiraVezCli=true, primeiraVezProd=true;
    conexao con_usuarios,con_nfvenda,con_prodVenda,con_estoque;
    int qtdestoquetinha=0;
    
    /**
     *
     */
    public saidaMercadorias() {
        
        initComponents();
        con_usuarios = new conexao();
        con_usuarios.conecta();
        
        con_nfvenda=new conexao();
        con_nfvenda.conecta();      
        
        
        con_prodVenda=new conexao();
        con_prodVenda.conecta();
        
        con_estoque=new conexao();
        con_estoque.conecta();
        
        con_usuarios.executeSQL("select * from cliente order by "+ordenacao);
        con_nfvenda.executeSQL("select * from notafiscalvenda");
        con_prodVenda.executeSQL("select * from produtosvenda");
        con_estoque.executeSQL("select * from estoque");  
       
        try
        {
            while(con_usuarios.resultset.next())
                cb_cliente.addItem(con_usuarios.resultset.getString("nome"));
            while(con_estoque.resultset.next())
                cbProduto.addItem(con_estoque.resultset.getString("produto"));
            
            atualiza_combo_box_cliente();
            con_nfvenda.resultset.first();
            mostrar_dados();
        }
catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não localizou dados "+erro);
        }  
        
        preencher_jtable();//chama metod para preencher a Tabela das Cidades
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_ordenacao = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();
        tf_datavenda = new javax.swing.JTextField();
        cb_cliente = new javax.swing.JComboBox();
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
        tf_codcli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_somatotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbProduto = new javax.swing.JComboBox();
        tfPrecoCusto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfCodProd = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_obs = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        tfPrecoVenda = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nota Fiscal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/saida_mercadorias.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 97);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Número da Nota Fiscal.:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 200, 160, 19);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Data da Venda.:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(300, 200, 110, 19);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Cliente.:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 240, 70, 19);
        getContentPane().add(tf_codigo);
        tf_codigo.setBounds(220, 200, 70, 23);

        tf_datavenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_datavendaActionPerformed(evt);
            }
        });
        getContentPane().add(tf_datavenda);
        tf_datavenda.setBounds(410, 200, 180, 23);

        cb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(cb_cliente);
        cb_cliente.setBounds(170, 240, 291, 23);

        botao_primeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Rewind.png"))); // NOI18N
        botao_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_primeiroActionPerformed(evt);
            }
        });
        getContentPane().add(botao_primeiro);
        botao_primeiro.setBounds(60, 320, 30, 30);

        botao_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Playback.png"))); // NOI18N
        botao_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_anteriorActionPerformed(evt);
            }
        });
        getContentPane().add(botao_anterior);
        botao_anterior.setBounds(120, 320, 30, 30);

        botao_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Play.png"))); // NOI18N
        botao_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_proximoActionPerformed(evt);
            }
        });
        getContentPane().add(botao_proximo);
        botao_proximo.setBounds(180, 320, 30, 30);

        botao_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fast-forward.png"))); // NOI18N
        botao_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_ultimoActionPerformed(evt);
            }
        });
        getContentPane().add(botao_ultimo);
        botao_ultimo.setBounds(250, 320, 30, 30);

        botão_gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Save.png"))); // NOI18N
        botão_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botão_gravarActionPerformed(evt);
            }
        });
        getContentPane().add(botão_gravar);
        botão_gravar.setBounds(480, 320, 30, 30);

        botao_inserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        botao_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_inserirActionPerformed(evt);
            }
        });
        getContentPane().add(botao_inserir);
        botao_inserir.setBounds(380, 320, 30, 30);

        botao_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Erase.png"))); // NOI18N
        botao_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirActionPerformed(evt);
            }
        });
        getContentPane().add(botao_excluir);
        botao_excluir.setBounds(430, 320, 30, 30);

        botao_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Modify.png"))); // NOI18N
        botao_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alterarActionPerformed(evt);
            }
        });
        getContentPane().add(botao_alterar);
        botao_alterar.setBounds(310, 320, 65, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código do Produto", "Nome do Produto", "Quantidade", "Preço Unit", "Preço Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 480, 850, 111);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
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
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 110, 617, 65);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
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
                .addContainerGap(13, Short.MAX_VALUE))
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

        getContentPane().add(jPanel2);
        jPanel2.setBounds(690, 110, 100, 110);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/View.png"))); // NOI18N
        jButton1.setText("Filtrar na Grade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 320, 148, 30);
        getContentPane().add(tf_codcli);
        tf_codcli.setBounds(120, 240, 33, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Total da Nota.:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(490, 240, 120, 19);
        getContentPane().add(tf_somatotal);
        tf_somatotal.setBounds(600, 240, 140, 23);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Observações Gerais.:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 280, 140, 19);

        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(cbProduto);
        cbProduto.setBounds(170, 450, 188, 23);
        getContentPane().add(tfPrecoCusto);
        tfPrecoCusto.setBounds(500, 450, 118, 23);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Nome do produto");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(210, 420, 120, 19);

        tfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantidadeFocusLost(evt);
            }
        });
        tfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantidadeActionPerformed(evt);
            }
        });
        getContentPane().add(tfQuantidade);
        tfQuantidade.setBounds(370, 450, 118, 23);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("Quant.");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(410, 420, 45, 19);
        getContentPane().add(tfCodProd);
        tfCodProd.setBounds(60, 450, 100, 23);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("Preço total");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(650, 420, 100, 19);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("Cod. Prod.");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(70, 420, 80, 19);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("Preço Unit.");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(520, 420, 72, 19);

        tf_obs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_obsActionPerformed(evt);
            }
        });
        getContentPane().add(tf_obs);
        tf_obs.setBounds(210, 280, 529, 23);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/BRIGHTS%20PRINTER_II.png"))); // NOI18N
        jButton3.setText("Impressão");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(740, 320, 123, 33);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search.png"))); // NOI18N
        jButton4.setText("Consulta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(770, 440, 109, 30);
        getContentPane().add(tfPrecoVenda);
        tfPrecoVenda.setBounds(630, 450, 118, 23);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Itens desta Nota Fiscal");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 370, 260, 40);

        setSize(new java.awt.Dimension(965, 649));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_proximoActionPerformed
 try
{
            con_nfvenda.resultset.next();
            mostrar_dados();
            preencher_jtable();
            navega = 2;
        }
catch(SQLException erro)
{
    JOptionPane.showMessageDialog(null,"Não foi possível ir para o próximo registro "+erro);
}    
    }//GEN-LAST:event_botao_proximoActionPerformed

    private void botão_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botão_gravarActionPerformed
        
       try
        {
            
            
            String sqlinsert ="insert into notafiscalvenda " +
                    "(numeronf, datavenda,codcliente,totaldanota,observacao) " +
                    " values ('"+
                    tf_codigo.getText()+"','"+
                    tf_datavenda.getText()+"','"+
                    tf_codcli.getText()+"','"+
                    tf_somatotal.getText()+"','"+
                    tf_obs.getText()+"')";
                    JOptionPane.showMessageDialog(null,"sql = "+sqlinsert);
                    con_nfvenda.statement.executeUpdate(sqlinsert);
            // JOptionPane.showMessageDialog(null,"Gravação realizado com sucesso!");
            
            //atualiza o ResultSet
            con_nfvenda.resultset = con_nfvenda.statement.executeQuery("Select * from notafiscalvenda");
            con_nfvenda.resultset.first(); //posiciona no primeiro registro
            mostrar_dados(); //irá chamar a função em que irá mstrar os dados no form
        }
catch (SQLException erro)
{
    JOptionPane.showMessageDialog(null,"Erro a tentar Gravar o registro..."+erro);
}      
    }                                        

    private void tfQuansaaLost(java.awt.event.FocusEvent evt) {                                      
      
        
    }//GEN-LAST:event_botão_gravarActionPerformed

    private void botao_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_primeiroActionPerformed
       try
            {
                 con_nfvenda.resultset.first();
                 mostrar_dados();
                 preencher_jtable();
            
            }
       
        catch(SQLException erro)
            
      {
            JOptionPane.showMessageDialog(null,"Não foi possível ir para o primeiro registro "+erro);
      }
    
    }//GEN-LAST:event_botao_primeiroActionPerformed

    private void botao_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_ultimoActionPerformed
         try
{
            con_nfvenda.resultset.last();
            mostrar_dados();
            preencher_jtable();
        }
catch(SQLException erro)
{
    JOptionPane.showMessageDialog(null,"Não foi possivel ir para o ultimo registro "+erro);
}
   
    }//GEN-LAST:event_botao_ultimoActionPerformed

    private void botao_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_anteriorActionPerformed
        try
{
            con_nfvenda.resultset.previous();
            mostrar_dados();
            preencher_jtable();
            navega=1;
        }
catch(SQLException erro)
{
    JOptionPane.showMessageDialog(null,"Não pode ir para o registro anterior "+erro);
}
    }//GEN-LAST:event_botao_anteriorActionPerformed

    private void botao_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_inserirActionPerformed
       
        
        tf_codigo.setText("");
        tf_datavenda.setText("");
        tf_codcli.setText("");
        tf_somatotal.setText("");
        tf_obs.setText("");
        tf_codigo.requestFocus();
      //  tf_codigo.setEditable(false);
        try
        {                
            con_nfvenda.executeSQL("select * from notafiscalvenda");
            con_nfvenda.resultset.last();
            int ultcod = con_nfvenda.resultset.getInt("numeronf") + 1;
            tf_datavenda.setText(""+ultcod);
        }    
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não localizou dados "+erro);
        }
        preencher_jtable();
    }//GEN-LAST:event_botao_inserirActionPerformed

    private void botao_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirActionPerformed
        
    }//GEN-LAST:event_botao_excluirActionPerformed

    private void botao_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alterarActionPerformed
       
    
    }//GEN-LAST:event_botao_alterarActionPerformed

    private void jcb_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_pesquisaActionPerformed
    
    }//GEN-LAST:event_jcb_pesquisaActionPerformed

    private void tf_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pesquisaActionPerformed
   
    }//GEN-LAST:event_tf_pesquisaActionPerformed

    private void rb_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_codigoActionPerformed
        ordem_visualizacao("codigo");
    }//GEN-LAST:event_rb_codigoActionPerformed

    private void rb_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_nomeActionPerformed
        ordem_visualizacao("nome");
    }//GEN-LAST:event_rb_nomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       con_prodVenda.executeSQL("select * from produtosvenda where nome like '"+tf_pesquisa.getText()+"%' order by "+ordenacao);
        preencher_jtable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
       if (primeiraVezProd == false)
       {
            try
            {
                String sql = "select * from estoque Where produto like '"+cbProduto.getSelectedItem()+"'";
                con_estoque.executeSQL(sql);
                con_estoque.resultset.first();
                tfCodProd.setText(con_estoque.resultset.getString("codigo"));
                tfPrecoCusto.setText(con_estoque.resultset.getString("precoCusto"));
                qtdestoquetinha = con_estoque.resultset.getInt("quantidade");
            }
            
            catch (SQLException erro)
{
                //JOptionPane.showMessageDialog(null,"Erro a tentar excluir o registro..."+erro);
            }
        }
        primeiraVezProd=false;
    
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void cb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clienteActionPerformed
        if (primeiraVezCli == false)
       {
            try
            {
                String sql = "select * from cliente Where nome like '"+cb_cliente.getSelectedItem()+"'";
                con_usuarios.executeSQL(sql);
                con_usuarios.resultset.first();
                tf_codcli.setText(con_usuarios.resultset.getString("codigo"));
            }
            
            catch (SQLException erro)
{
                //JOptionPane.showMessageDialog(null,"Erro a tentar excluir o registro..."+erro);
            }
        }
        primeiraVezCli=false;
    }//GEN-LAST:event_cb_clienteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_obsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_obsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_obsActionPerformed

    private void tfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusLost
        tfPrecoVenda.setText(String.valueOf(Double.parseDouble(tfQuantidade.getText()) * 
              Double.parseDouble(tfPrecoCusto.getText())));
    }//GEN-LAST:event_tfQuantidadeFocusLost

    private void tfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuantidadeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
    {
             
            String sqlinsert ="insert into produtosvenda " +
                    "(codigonf,codigoproduto,nomeproduto," +
                    "quantidade,precounitario,precovenda" +
                    ") values ('"+
                    tf_codigo.getText()+"','"+
                    tfCodProd.getText()+"','"+
                    cbProduto.getSelectedItem()+"','"+
                    tfQuantidade.getText()+"','"+
                    tfPrecoCusto.getText()+"','"+
                    tfPrecoVenda.getText()+"')";
                    JOptionPane.showMessageDialog(null,"sql = "+sqlinsert);
                    con_prodVenda.statement.executeUpdate(sqlinsert);
                    JOptionPane.showMessageDialog(null,"Gravação realizado com sucesso!");           
                    //atualiza o ResultSet
                    //con_usuarios.resultset = con_usuarios.statement.executeQuery("Select * from cliente");
                    //con_estoque.executeSQL("select * from estoque  order by "+ordenacao);
                    //atualizaComboBoxEstoque();
                    //con_estoque.resultset.first(); //posiciona no primeiro registro
                    preencher_jtable();
        }
catch (SQLException erro)
{
    JOptionPane.showMessageDialog(null,"Erro a tentar Gravar o registro..."+erro);
}
atualizaEstoque();
                                         

    }//GEN-LAST:event_jButton4ActionPerformed

    private void tf_datavendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_datavendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_datavendaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cad_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cad_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cad_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cad_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new saidaMercadorias().setVisible(true);
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
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JComboBox cb_cliente;
    private javax.swing.ButtonGroup grupo_ordenacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox jcb_pesquisa;
    private javax.swing.JRadioButton rb_codigo;
    private javax.swing.JRadioButton rb_nome;
    private javax.swing.JTextField tfCodProd;
    private javax.swing.JTextField tfPrecoCusto;
    private javax.swing.JFormattedTextField tfPrecoVenda;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tf_codcli;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_datavenda;
    private javax.swing.JTextField tf_obs;
    private javax.swing.JTextField tf_pesquisa;
    private javax.swing.JTextField tf_somatotal;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void mostrar_dados()
    { 
          try
         {
          
            tf_codigo.setText(con_nfvenda.resultset.getString("numeronf"));
            tf_datavenda.setText(con_nfvenda.resultset.getString("datavenda"));
            tf_codcli.setText(con_nfvenda.resultset.getString("codcliente"));
            tf_somatotal.setText(con_nfvenda.resultset.getString("totaldanota"));
            tf_obs.setText(con_nfvenda.resultset.getString("observacao"));
            

            atualizaComboBoxCli();
        }
        catch(SQLException erro)
        {
            if (navega == 1)
               JOptionPane.showMessageDialog(null,"Olha, você já está no primeiro registro");
            else if (navega == 2)
               JOptionPane.showMessageDialog(null,"Olha, você já está no último registro");
           else
               JOptionPane.showMessageDialog(null,"Não localizou dados "+erro);
           navega=0;
        }  
    }

    /**
     *
     */
    public void atualiza_combo_box_cliente()
    {
        try
        {
          jcb_pesquisa.removeAllItems();
          con_usuarios.executeSQL("select * from cliente order by "+ordenacao);
          while(con_usuarios.resultset.next())
              jcb_pesquisa.addItem(con_usuarios.resultset.getString("nome"));           
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
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        con_prodVenda.executeSQL("select * from produtosvenda where codigonf = "+tf_codigo.getText());
        
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
        
        try
       {
            
            while (con_prodVenda.resultset.next())
                modelo.addRow(new Object [] {con_prodVenda.resultset.getString("codigoproduto"),con_prodVenda.resultset.getString("nomeproduto"),con_prodVenda.resultset.getString("quantidade"),con_prodVenda.resultset.getString("precounitario"),con_prodVenda.resultset.getString("precovenda")});
            con_prodVenda.resultset.first();
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
        con_usuarios.executeSQL("select * from cliente  order by "+ordenacao);           
        preencher_jtable();
        atualiza_combo_box_cliente();
        try
        {
            con_usuarios.resultset.first();
        }
         catch (SQLException erro){
             JOptionPane.showMessageDialog(null,"Erro na ordenação dos dados "+erro);
        }
        mostrar_dados();
        
    }

    /**
     *
     */
    public void atualizaEstoque()
    {
        //código para atualizar estoque
        int estoqueatual = qtdestoquetinha - Integer.parseInt(tfQuantidade.getText().trim());
        try
        {
            String sql ="UPDATE estoque SET quantidade = '"+estoqueatual+
                    "' where codigo = "+tfCodProd.getText();
            JOptionPane.showMessageDialog(null,"sql = "+sql);
            con_estoque.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Dado Baixa no Estoque com sucesso!");
            
            
        }
        catch (SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Erro a tentar dar baixa no estoque.."+erro);
        }
    }

    /**
     *
     */
    public void atualizaComboBoxCli()
{
        // procedimento para atualizar jcombobox de cliente
        try
        {
            String sql = "select * from cliente Where codigo ="+tf_codcli.getText();
            con_usuarios.executeSQL(sql);
            con_usuarios.resultset.first();
            cb_cliente.setSelectedItem(con_usuarios.resultset.getString("nome"));
        }
        catch (SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Nao foi possivel localizar Cliente");
            tf_codcli.requestFocus();            
        }
      }
     
}