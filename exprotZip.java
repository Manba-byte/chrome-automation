@SneakyThrows
    private Map defaultExport(List<?> list, Class<?> pojoClass, String fileName,
                               HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,pojoClass,list);
        //if (workbook != null); downLoadExcel(fileName, response, workbook);
        List<Workbook> workbookList = new ArrayList<>();
        workbookList.add(workbook);
        String[] files = {"test压缩.xlsx"};
        File file = ExportAndZipUtil.zipFile(workbookList, files);
        try {
            return OSSUtils.uploadFile(file.getPath(), "test11.zip");
        }finally {
            file.delete();
        }



       /* String downloadFileName = URLEncoder.encode("XX商户XX公司XXXX报税单销售汇总信息.zip", "UTF-8");
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/x-execl");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String((downloadFileName).getBytes(), "UTF-8"));
        // 读取文件
        InputStream in = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        // 写文件
        int b;
        while ((b = in.read()) != -1) {
            outputStream.write(b);
        }
        in.close();
        outputStream.close();*/
        //删除临时文件

    }
