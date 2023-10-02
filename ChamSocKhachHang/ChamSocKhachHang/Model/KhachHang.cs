using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChamSocKhachHang.Model
{
    public class KhachHang
    {
        public string MaKH { get; set; }
        public string TenKH { get; set; }
        public string SDT { get; set; }
        public string DiaChi { get; set; }

        public KhachHang(string makh, string tenkh, string sdt, string diachi)
        {
            MaKH = makh;
            TenKH = tenkh;
            SDT = sdt;
            DiaChi = diachi;
        }

        public KhachHang()
        {

        }
    }
}
