import { Pipe, PipeTransform } from '@angular/core';
@Pipe({
  name: 'issuecountfilter'
})
export class FilterPipe implements PipeTransform {
  transform(items: any[],issueCount : string): any[] {
 if(!items) return [];
    if(!issueCount) return items;
    issueCount = issueCount.toLowerCase();
return items.filter( it => {
       if(it["Issue count"] === issueCount)
         return it;
    });
   }
}