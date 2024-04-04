export class SpecificationFile {
  specFileId: string;
  userId: string;
  file_path: string;
  name: string;

  constructor(
    specFileId: any = '',
    userId: any = '',
    file_path: string = '',
    name: string = ''
  ) {
    this.specFileId = specFileId as string;
    this.userId = userId as string;
    this.file_path = file_path;
    this.name = name;
  }
}
