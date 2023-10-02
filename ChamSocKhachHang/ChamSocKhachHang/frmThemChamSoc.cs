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
    public partial class frmThemChamSoc : Form
    {
        public KhachHang _kh { get; set; }
        public frmThemChamSoc()
        {
            InitializeComponent();
        }

        public frmThemChamSoc(KhachHang kh)
        {
            InitializeComponent();
            _kh = kh;
        }

        private void btnHuy_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
