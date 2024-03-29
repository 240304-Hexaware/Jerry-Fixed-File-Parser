export class Record {
  recordId: string;
  fixedFileId: string;
  specFileId: string;
  keys: string[];
  values: string[];

  constructor(
    recordId: string = '',
    fixedFileId: string = '',
    specFileId: string = '',
    keys: string[],
    values: string[],
  ) {
    this.recordId = recordId;
    this.fixedFileId = fixedFileId;
    this.specFileId = specFileId;
    this.keys = keys;
    this.values = values;
  }
}
