package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox<String> cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JComboBox<String> cboProveedores;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		//
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		List<Producto> prod = em.createQuery("select p from Producto p", Producto.class).getResultList();
		//
		txtCódigo.setText("P00" + (prod.size()+1));
		txtCódigo.setEditable(false);
		em.close();
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox<String>();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		JLabel lblProveedores = new JLabel("Proveedor:");
		lblProveedores.setBounds(230, 106, 102, 14);
		
		contentPane.add(lblProveedores);
		cboProveedores = new JComboBox<String>();
		cboProveedores.setBounds(300, 104, 120, 22);
		contentPane.add(cboProveedores);
		
		llenaCombo();
	}

	void llenaCombo() {
		try {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fabrica.createEntityManager();
			
			List<Categoria> lista = em.createQuery("select c from Categoria c", Categoria.class).getResultList();
			
			for (Categoria categoria : lista) {
				cboCategorias.addItem(categoria.getDescripcion());
			}
			
			
			List<Proveedor> lista2 = em.createQuery("select p from Proveedor p", Proveedor.class).getResultList();
			
			for (Proveedor proveedor : lista2) {
				cboProveedores.addItem(proveedor.getNombre_rs());
			}
			em.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static long tini;
	static long tfin;
	void listado() {
		tini = System.nanoTime();
		try {
			System.nanoTime();
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em =  fabrica.createEntityManager();
			
			List<Producto> lista = em.createQuery("select p from Producto p", Producto.class).getResultList();
			
			txtSalida.setText("");
			for (Producto producto : lista) {
				txtSalida.append("************************************************" + "\n");
				txtSalida.append("Id Producto : " + producto.getId_prod() + "\n");
				txtSalida.append("Descripcicon: " + producto.getDes_prod() + "\n");
				txtSalida.append("Stock    : " + Integer.toString(producto.getStk_prod()) + "\n");
				txtSalida.append("Precio   : " + Double.toString(producto.getPre_prod()) + "\n");
				//txtSalida.append("Id Categoria: " +Integer.toString(producto.getIdcategoria())+"\n");
				txtSalida.append("Id Categoria: " +producto.getCategoria().getDescripcion()+"\n");
				txtSalida.append("Estado   : " +Integer.toString(producto.getEst_prod())+"\n");
				txtSalida.append("Id Proveedor: " +producto.getProveedor().getNombre_rs()+"\n\n");
			}			
			em.close();
			tfin = System.nanoTime();
			System.out.println(tfin-tini);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	void registrar() {
		//entradas
		String codigo = txtCódigo.getText();
		String descripccion = txtDescripcion.getText();
		int stock = Integer.parseInt(txtStock.getText());
		double precio = Double.parseDouble(txtPrecio.getText());
		int categoria = (cboCategorias.getSelectedIndex()+1);
		int estado = 1; //por defecto para activo
		int proveedor = (cboProveedores.getSelectedIndex()+1);
		
		//proceso
		Producto p = new Producto();
		p.setId_prod(codigo);
		p.setDes_prod(descripccion);
		p.setStk_prod(stock);
		p.setPre_prod(precio);
		p.setIdcategoria(categoria);
		p.setEst_prod(estado);
		p.setIdprovedor(proveedor);
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager  em = fabrica .createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		List<Producto> prod = em.createQuery("select p from Producto p", Producto.class).getResultList();
		txtCódigo.setText("P00" + (prod.size()+1));
		em.close();
		
		JOptionPane.showMessageDialog(this, "Producto registrado");
		
		txtDescripcion.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
		cboCategorias.setSelectedItem(0);
		cboProveedores.setSelectedIndex(0);
	}
}
