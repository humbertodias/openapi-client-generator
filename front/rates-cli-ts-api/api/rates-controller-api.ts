/* tslint:disable */
/* eslint-disable */
/**
 * OpenAPI definition
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import globalAxios, { AxiosResponse, AxiosInstance, AxiosRequestConfig } from 'axios';
import { Configuration } from '../configuration';
// Some imports not used depending on template conditions
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, RequestArgs, BaseAPI, RequiredError } from '../base';
import { CurrenciesDate } from '../models';
/**
 * RatesControllerApi - axios parameter creator
 * @export
 */
export const RatesControllerApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @param {string} date 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getCurrencies: async (date: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'date' is not null or undefined
            if (date === null || date === undefined) {
                throw new RequiredError('date','Required parameter date was null or undefined when calling getCurrencies.');
            }
            const localVarPath = `/rates/{date}/currencies`
                .replace(`{${"date"}}`, encodeURIComponent(String(date)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions :AxiosRequestConfig = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.params) {
                query.set(key, options.params[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @param {string} date 
         * @param {string} currencyCode 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getRateByCharCode: async (date: string, currencyCode: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'date' is not null or undefined
            if (date === null || date === undefined) {
                throw new RequiredError('date','Required parameter date was null or undefined when calling getRateByCharCode.');
            }
            // verify required parameter 'currencyCode' is not null or undefined
            if (currencyCode === null || currencyCode === undefined) {
                throw new RequiredError('currencyCode','Required parameter currencyCode was null or undefined when calling getRateByCharCode.');
            }
            const localVarPath = `/rates/{date}/{currencyCode}`
                .replace(`{${"date"}}`, encodeURIComponent(String(date)))
                .replace(`{${"currencyCode"}}`, encodeURIComponent(String(currencyCode)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions :AxiosRequestConfig = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.params) {
                query.set(key, options.params[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * RatesControllerApi - functional programming interface
 * @export
 */
export const RatesControllerApiFp = function(configuration?: Configuration) {
    return {
        /**
         * 
         * @param {string} date 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getCurrencies(date: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => Promise<AxiosResponse<Array<string>>>> {
            const localVarAxiosArgs = await RatesControllerApiAxiosParamCreator(configuration).getCurrencies(date, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs :AxiosRequestConfig = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
        /**
         * 
         * @param {string} date 
         * @param {string} currencyCode 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getRateByCharCode(date: string, currencyCode: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => Promise<AxiosResponse<CurrenciesDate>>> {
            const localVarAxiosArgs = await RatesControllerApiAxiosParamCreator(configuration).getRateByCharCode(date, currencyCode, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs :AxiosRequestConfig = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
    }
};

/**
 * RatesControllerApi - factory interface
 * @export
 */
export const RatesControllerApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    return {
        /**
         * 
         * @param {string} date 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getCurrencies(date: string, options?: AxiosRequestConfig): Promise<AxiosResponse<Array<string>>> {
            return RatesControllerApiFp(configuration).getCurrencies(date, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @param {string} date 
         * @param {string} currencyCode 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getRateByCharCode(date: string, currencyCode: string, options?: AxiosRequestConfig): Promise<AxiosResponse<CurrenciesDate>> {
            return RatesControllerApiFp(configuration).getRateByCharCode(date, currencyCode, options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * RatesControllerApi - object-oriented interface
 * @export
 * @class RatesControllerApi
 * @extends {BaseAPI}
 */
export class RatesControllerApi extends BaseAPI {
    /**
     * 
     * @param {string} date 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof RatesControllerApi
     */
    public async getCurrencies(date: string, options?: AxiosRequestConfig) : Promise<AxiosResponse<Array<string>>> {
        return RatesControllerApiFp(this.configuration).getCurrencies(date, options).then((request) => request(this.axios, this.basePath));
    }
    /**
     * 
     * @param {string} date 
     * @param {string} currencyCode 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof RatesControllerApi
     */
    public async getRateByCharCode(date: string, currencyCode: string, options?: AxiosRequestConfig) : Promise<AxiosResponse<CurrenciesDate>> {
        return RatesControllerApiFp(this.configuration).getRateByCharCode(date, currencyCode, options).then((request) => request(this.axios, this.basePath));
    }
}
