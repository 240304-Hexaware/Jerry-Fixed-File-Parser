export class FixedFile {
    fixedFileId: string;
    userId: string;
    file_path: string;
    name: string;
  
    constructor(
      fixedFileId: string = '',
      userId: string = '',
      file_path: string = '',
      name: string = ''
    ) {
      this.fixedFileId = fixedFileId;
      this.userId = userId;
      this.file_path = file_path;
      this.name = name;
    }
}
