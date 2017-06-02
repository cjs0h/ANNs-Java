package com.hayderalgorabi.ANNs;
public class Encoder {
    private String _DataPath;
    private String _OutputDataPath = "out.csv";
    public void SetOutputDataPath(String OutputDataPath){
        this._OutputDataPath = OutputDataPath;
    }
    List<Dataset> ds = new ArrayList<Dataset>();
    public void SetInputDataPath(String path){
        _DataPath = path;
    }
    public void BuildDataset() throws Exception {
        FileOutputStream Out = new FileOutputStream(_OutputDataPath);
        BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(Out));
        FileInputStream file = new FileInputStream(_DataPath);
        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        String strLine,Data;
        String[] Temp;
        double[] InputArry = new double[32];
        double Output;
        while ((strLine = br.readLine()) != null)
        {
            Temp = strLine.split(",");
            Data = MD5(Temp[0]);
            for(int i =0;i<Data.length();i++){
                InputArry[i] = (double)Data.charAt(i)/100;
            }
            Data = Temp[1];
            Output = 0d;
            for(int i =0;i<InputArry.length;i++){
                Writer.write(String.valueOf(InputArry[i]));
                Writer.write(",");
            }
            Random R = new Random();
            Output = R.nextDouble();
            while (Output <= 0.15)
               Output = R.nextDouble();
            Dataset Obj = new Dataset(Data,Output);
                double Rnd = R.nextDouble();
                while (Rnd <= .15)
                Rnd = R.nextDouble();
                Output = Double.parseDouble(new DecimalFormat("#.#####").format(Rnd));
                for(int c =0;c<ds.size();c++){
                    if(ds.get(c).GetName().equals(Data)){
                        Output = ds.get(c).GetOutPut();
                        Obj = new Dataset(Data,Output);
                    }
                }
                ds.add(Obj);
            Writer.write(String.valueOf(new DecimalFormat("#.#####").format(Obj.GetOutPut())));
            Writer.newLine();
        }
        Writer.close();
        br.close();
    }
    public String BuildTestData(String Input){
        String encoded = MD5(Input);
        String ret = "";
        for(int i =0;i<encoded.length();i++){
            ret += String.valueOf((double)encoded.charAt(i)/100);
            ret += ",";
        }
        ret += "0";
        return ret;
    }
    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
