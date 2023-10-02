using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ChamSocKhachHang.Model;

namespace ChamSocKhachHang
{
    public partial class frmKhachHang : Form
    {
        DataGridViewComboBoxColumn cbo = new DataGridViewComboBoxColumn();
        public frmKhachHang()
        {
            InitializeComponent();
            List<KhachHang> lstKhachHang = new List<KhachHang>();
            lstKhachHang.Add(new KhachHang("KH001", "Võ Thị Hiếu", "0023635236", "140 Nguyễn Hoa La"));
            lstKhachHang.Add(new KhachHang("KH002", "Nguyễn Lễ Thi", "0928648279", "293 Nguyễn Sơn"));
            lstKhachHang.Add(new KhachHang("KH003", "Lâm Họa Mi", "0748546796", "52 Nguyễn Trứ Phát"));

            string[] lstAction = { "Tạo chăm sóc", "Sửa chăm sóc", "Xóa chăm sóc" };
            BindingSource bs = new BindingSource();
            bs.DataSource = lstAction;
            cbo.DataSource = bs;
            drvKhachHang.Columns.Add(cbo);

            foreach(KhachHang kh in lstKhachHang){
                DataGridViewRow row = new DataGridViewRow();
                row.CreateCells(drvKhachHang);
                row.Cells[0].Value = kh.MaKH;
                row.Cells[1].Value = kh.TenKH;
                row.Cells[2].Value = kh.SDT;
                row.Cells[3].Value = kh.DiaChi;
                drvKhachHang.Rows.Add(row);
            }

            drvKhachHang.CellValueChanged += drvKhachHang_CellValueChanged;
            drvKhachHang.CurrentCellDirtyStateChanged += drvKhachHang_CurrentCellDirtyStateChanged;
        }

        void drvKhachHang_CurrentCellDirtyStateChanged(object sender, EventArgs e)
        {
            string value = drvKhachHang.CurrentCell.EditedFormattedValue.ToString();
            DataGridViewRow row = drvKhachHang.CurrentRow;
            if ("Tạo chăm sóc".Equals(value))
            {
                KhachHang kh = new KhachHang();
                kh.MaKH = row.Cells[0].Value.ToString();
                kh.TenKH = row.Cells[1].Value.ToString();
                frmThemChamSoc frm = new frmThemChamSoc();
                frm.Show();
                row.Cells[4].Value = null;
            }
        }

        void drvKhachHang_CellValueChanged(object sender, DataGridViewCellEventArgs e)
        {
            DataGridViewComboBoxCell cboCell = (DataGridViewComboBoxCell)drvKhachHang.Rows[e.RowIndex].Cells[4];
            if (cboCell != null)
            {
                Console.WriteLine("Chọn " + cboCell.Value + " tại dòng " + e.RowIndex);
            }
        }

        private void drvKhachHang_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            DataGridViewRow row = drvKhachHang.CurrentRow;
            if (e.RowIndex < 0)
            {
                return;
            }
            
            if((DataGridViewComboBoxCell)drvKhachHang.Rows[e.RowIndex].Cells[4] != null){
                DataGridViewComboBoxCell cboCell = (DataGridViewComboBoxCell)drvKhachHang.Rows[e.RowIndex].Cells[4];
                Console.WriteLine("Chọn " + cboCell.Value + " tại dòng " + e.RowIndex);
            }
        }

        private void frmKhachHang_Load(object sender, EventArgs e)
        {

        }
    }
}
