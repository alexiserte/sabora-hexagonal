using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Text.Json;
using System.Net.NetworkInformation;

namespace GlassesPartOfProtocol.Utils
{
    class UserData
    {
        class RespuestaIp { public string Ip { get; set; } }

        private static readonly HttpClient client = new HttpClient();
        public static string generateID()
        {
            int[] asciiTotal = new int[10 + 26 + 26]; int index = 0;
            string res = "";
            Random r = new Random();
            for (int i = 0; i < 10; i++) asciiTotal[index++] = '0' + i;
            for (int i = 0; i < 26; i++) asciiTotal[index++] = 'A' + i;
            for (int i = 0; i < 26; i++) asciiTotal[index++] = 'a' + i;

            for (int i = 0; i < 64; i++) res += (char)asciiTotal[r.Next(0, asciiTotal.Length)];
            return res;
        }

        public static async Task<string> ObtenerDireccionIP()
        {   
            try
            {
                HttpResponseMessage response = await client.GetAsync("https://api.ipify.org?format=json");
                response.EnsureSuccessStatusCode();  // Lanza una excepción si no es un código 2xx
                string responseBody = await response.Content.ReadAsStringAsync();

                // Deserializar el JSON a un objeto RespuestaIp
                RespuestaIp resultado = JsonSerializer.Deserialize<RespuestaIp>(responseBody);

                return resultado.Ip;
            }
            catch (HttpRequestException e)
            {
                return $"Error en la solicitud: {e.Message}";
            }
        }

        public static string ObtenerDireccionMac()
        {
            foreach (NetworkInterface nic in NetworkInterface.GetAllNetworkInterfaces())
            {
                if (nic.OperationalStatus == OperationalStatus.Up) // Solo interfaces activas
                {
                    return nic.GetPhysicalAddress().ToString();
                }
            }
            return "No se encontró una interfaz de red activa.";
        }
    }
}
